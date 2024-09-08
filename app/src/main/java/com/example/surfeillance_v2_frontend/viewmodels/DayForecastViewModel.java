package com.example.surfeillance_v2_frontend.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.model.repository.ForecastRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DayForecastViewModel extends AndroidViewModel {

    private ForecastRepository repository;
    private long spotId;
    private String date;

    // viewmodels only exist for the lifecycle of the activity/fragment, but survives things like orientation changes, and other things?
    // passing arguments from the acitivity to the viewmodel would make them less decoupled which is bad for flexibility and testing
    //
    public DayForecastViewModel(@NotNull Application application, long spotId, String date ) {
        super(application);
        this.repository = new ForecastRepository(application, spotId, date);
    }

    public LiveData<List<ForecastEntity>> getHourlyForecastsAtSpotOnDate(){
        return repository.getHourlyForecastsAtSpotOnDate();

    }

}
