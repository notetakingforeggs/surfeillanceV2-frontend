package com.example.surfeillance_v2_frontend.views.weeklyForecasts;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.viewmodels.WeeklyForecastViewModelFactory;
import com.example.surfeillance_v2_frontend.viewmodels.WeeklyForecastsViewModel;

import java.util.List;

public class WeeklyForecastActivity extends AppCompatActivity {

    private String TAG = "weekly forecast";
    private WeeklyForecastsViewModel viewModel;
    private WeeklyForecastAdaptor adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weekly_forecast);

        Intent intent = getIntent();
        Long spotID = intent.getLongExtra("spotID", -1);
        WeeklyForecastViewModelFactory factory = new WeeklyForecastViewModelFactory(getApplication(), spotID);

        viewModel = new ViewModelProvider(this, factory).get(WeeklyForecastsViewModel.class);
        viewModel.getForecastsLiveData().observe(this, new Observer<List<ForecastEntity>>() {
           @Override
           public void onChanged(List<ForecastEntity> forecastEntities) {
               adaptor = new WeeklyForecastAdaptor(forecastEntities);
               adaptor.updateForecasts(forecastEntities);
           }
       });
    }
}