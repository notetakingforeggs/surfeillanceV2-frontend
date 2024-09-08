package com.example.surfeillance_v2_frontend.views.dayforecasts;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.viewmodels.DayForecastViewModel;
import com.example.surfeillance_v2_frontend.viewmodels.DayForecastViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class DayForecast extends AppCompatActivity {

    String TAG = "dayForecast";

    private RecyclerView recyclerview;
    private TextView spotTitle, dayDate;
    private String date;
    private long spotId;
    private List<ForecastEntity> forecasts;
    private DayForecastViewModel viewModel;
    private DayForecastViewModelFactory factory;
    private DayForecastAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_day_forecast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // initialise
        forecasts = new ArrayList<>();
        Intent intent = getIntent();
        spotId = intent.getLongExtra("spotID", -1);
        date = intent.getStringExtra("date");
        Log.i(TAG, "onCreate: " + date);
        adaptor = new DayForecastAdaptor(new ArrayList<>());

        recyclerview = findViewById(R.id.hourlyRecyclerView);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adaptor);

        factory = new DayForecastViewModelFactory(getApplication(), spotId, date);
        viewModel = new ViewModelProvider(this, factory).get(DayForecastViewModel.class);


        viewModel.getHourlyForecastsAtSpotOnDate().observe(this, new Observer<List<ForecastEntity>>() {
            @Override
            public void onChanged(List<ForecastEntity> forecastEntities) {
                forecasts = forecastEntities;
                System.out.println(forecastEntities.get(0).getName());
                spotTitle.setText(forecastEntities.get(0).getName());
                dayDate.setText(forecastEntities.get(0).getDate());
                adaptor.updateForecasts(forecasts);

            }
        });
    }
}