package com.example.surfeillance_v2_frontend.viewmodels;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.model.repository.ForecastRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WeeklyForecastsViewModel extends AndroidViewModel {
    private  String TAG = "weeklyVM";
    private ForecastRepository forecastRepository;
    private LiveData<List<ForecastEntity>> forecastsLiveData;


    public WeeklyForecastsViewModel(@NotNull Application application, Long spotId) {
        super(application);
        Log.i(TAG, "WeeklyForecastsViewModel: ");
        forecastRepository = new ForecastRepository(application, spotId);
        forecastsLiveData = forecastRepository.getSimpleDayForecasts();
    }

    public LiveData<List<ForecastEntity>> getForecastsLiveData(){
        return forecastsLiveData;
    }

}
