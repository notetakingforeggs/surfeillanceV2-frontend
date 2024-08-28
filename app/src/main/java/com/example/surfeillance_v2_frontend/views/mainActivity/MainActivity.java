package com.example.surfeillance_v2_frontend.views.mainActivity;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.viewmodels.MainActivityViewModel;
import com.google.android.material.textview.MaterialTextView;

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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptor = new MainActivityAdaptor(new ArrayList<>());
        recyclerView.setAdapter(adaptor);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);


        viewModel.refreshLocalDB();

        viewModel.getFirstDecentsLiveData().observe(this, new Observer<List<ForecastEntity>>() {
            @Override
            public void onChanged(List<ForecastEntity> forecastEntities) {
                for (ForecastEntity entity : forecastEntities) {
                    System.out.println(entity.getName() + "has decent surf coming up");
                }
                apology.setVisibility(forecastEntities.isEmpty() ? View.VISIBLE : View.GONE);
                recyclerView.setVisibility(forecastEntities.isEmpty() ? View.INVISIBLE : View.VISIBLE);
                adaptor.updateForecasts(forecastEntities);
            }

        });

        /* TODO commenting this out for now, but likely to use it in later activities.
        viewModel.getForecastsLiveData().observe(this, new Observer<List<ForecastEntity>>() {
            @Override
            public void onChanged(List<ForecastEntity> forecastEntities) {
                for(ForecastEntity entity : forecastEntities){
                    System.out.println(entity);
                }
            }
        });*/
    }
}