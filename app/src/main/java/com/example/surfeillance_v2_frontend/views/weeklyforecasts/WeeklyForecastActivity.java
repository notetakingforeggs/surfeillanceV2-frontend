package com.example.surfeillance_v2_frontend.views.weeklyforecasts;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.viewmodels.WeeklyForecastViewModelFactory;
import com.example.surfeillance_v2_frontend.viewmodels.WeeklyForecastsViewModel;
import com.example.surfeillance_v2_frontend.views.OnItemClickListener;
import com.example.surfeillance_v2_frontend.views.dayforecasts.DayForecast;

import java.util.ArrayList;
import java.util.List;


public class WeeklyForecastActivity extends AppCompatActivity implements OnItemClickListener {

    private String TAG = "weekly forecast";
    private WeeklyForecastsViewModel viewModel;
    private WeeklyForecastAdaptor adaptor;
    private RecyclerView recyclerView;
    private long spotID;
    private TextView spotName;
    private List<ForecastEntity> forecasts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_forecast);

        adaptor = new WeeklyForecastAdaptor(new ArrayList<>());

        recyclerView = findViewById(R.id.forecast_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);
        adaptor.setOnItemClickListener(this);
        spotName = findViewById(R.id.location_name);

        Intent intent = getIntent();
        spotID = intent.getLongExtra("spotID", -1);

        WeeklyForecastViewModelFactory factory = new WeeklyForecastViewModelFactory(getApplication(), spotID);

        viewModel = new ViewModelProvider(this, factory).get(WeeklyForecastsViewModel.class);
        viewModel.getForecastsLiveData().observe(this, new Observer<List<ForecastEntity>>() {
            @Override
            public void onChanged(List<ForecastEntity> forecastEntities) {
                System.out.println(forecastEntities.size() + " forecasts for one spot?");
                forecasts = forecastEntities;
                // is there an issue with readiness here? maybe need a wait clause in or smth somehow. Click too fast and breaks perhaps
                // or maybe it was the room query went through whilst refreshing was happening?
                spotName.setText(forecastEntities.get(1).getName());
                adaptor.updateForecasts(forecastEntities);
            }
        });


    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(WeeklyForecastActivity.this, DayForecast.class);
        Bundle extras = new Bundle();
        extras.putLong("spotID", spotID);
        extras.putString("date", forecasts.get(position).getDate());
        Log.i(TAG, "onItemClick: " + forecasts.get(position).getDate());
        intent.putExtras(extras);
        startActivity(intent);

    }
}