package com.example.surfeillance_v2_frontend.views.mainactivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.viewmodels.MainActivityViewModel;
import com.example.surfeillance_v2_frontend.views.OnItemClickListener;
import com.example.surfeillance_v2_frontend.views.weeklyforecasts.WeeklyForecastActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private MainActivityViewModel viewModel;
    private MainActivityAdaptor adaptor;
    private List<ForecastEntity> forecasts;

    private TextView apology;
    private RecyclerView recyclerView;


    // rather than scheduling updates, check to see if timestamp of forecast data is x hours behind system time, and do api call if so each time new information is accessed?
    // TODO get a sunset/sunrise api in to be able to select only for daylight forecasts
    // maybe move a bunch of stuff ot the backend? and only send what i need to the front?
    // put the isdecent function in the back

    // USP on this is only see forecsats if there is some surf worth considering otherwise just dont even get into the app.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        apology = findViewById(R.id.apology);
        forecasts = new ArrayList<ForecastEntity>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // adaptor takes this as the listener asis class now implements the listener interface so is a listener?
        adaptor = new MainActivityAdaptor(new ArrayList<>());
        recyclerView.setAdapter(adaptor);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // TODO this needs to be put elsewhere, and done on a scheduled basis, alongisde checks for how recently the data in the room db has been updated.
        viewModel.refreshLocalDB();

        viewModel.getFirstDecentsLiveData().observe(this, new Observer<List<ForecastEntity>>() {
            @Override
            public void onChanged(List<ForecastEntity> forecastEntities) {
                forecasts.addAll(forecastEntities);

                // this visibility/non visibility should be refactored into the view model
                apology.setVisibility(forecastEntities.isEmpty() ? View.VISIBLE : View.GONE);
                recyclerView.setVisibility(forecastEntities.isEmpty() ? View.INVISIBLE : View.VISIBLE);

                adaptor.updateForecasts(forecastEntities);
            }

        });

        adaptor.setOnItemCLickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, WeeklyForecastActivity.class);
                Long spotId = forecasts.get(position).getSpotId();
                Log.i(TAG, "onItemClick: " + spotId);
                intent.putExtra("spotID", spotId);
                Toast.makeText(getApplicationContext(), "Taking you to weekly forecast for " + forecasts.get(position).getName(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }


}