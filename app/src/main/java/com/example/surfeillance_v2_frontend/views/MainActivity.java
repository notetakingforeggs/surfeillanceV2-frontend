package com.example.surfeillance_v2_frontend.views;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.surfeillance_v2_frontend.R;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.viewmodels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private MainActivityViewModel viewModel;

   private List<ForecastEntity> forecasts;

    // rather than scheduling updates, check to see if timestamp of forecast data is x hours behind system time, and do api call if so each time new information is accessed?
    // TODO get a sunset/sunrise api in to be able to select only for daylight forecasts
    // maybe move a bunch of stuff ot the backend? and only send what i need to the front?
    // put the isdecent function in the back

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.refreshLocalDB();

        viewModel.getFirstDecentsLiveData().observe(this, new Observer<List<ForecastEntity>>() {
            @Override
            public void onChanged(List<ForecastEntity> forecastEntities) {
                for(ForecastEntity entity : forecastEntities){
                    System.out.println(entity);
                }
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