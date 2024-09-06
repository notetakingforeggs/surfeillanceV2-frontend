package com.example.surfeillance_v2_frontend.viewmodels;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import org.jetbrains.annotations.NotNull;

public class DayForecastViewModelFactory implements ViewModelProvider.Factory {
    private Application app;
    private long spotId;
    private String date;


    public DayForecastViewModelFactory(Application app, long spotId, String date) {
        this.app = app;
        this.spotId = spotId;
        this.date = date;
    }

    @Override
    public @NotNull <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(DayForecastViewModel.class)){
            return (T) new DayForecastViewModel( app, spotId, date);
        }
        throw new IllegalArgumentException("unknown viewmodel in daily factory");
    }
}
