package com.example.surfeillance_v2_frontend.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class WeeklyForecastViewModelFactory implements ViewModelProvider.Factory{
private Application app;
private Long spotId;

    public WeeklyForecastViewModelFactory(Application app, Long spotId) {
        this.app = app;
        this.spotId = spotId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(WeeklyForecastsViewModel.class)) {
            return (T) new WeeklyForecastsViewModel(app, spotId);
        }
        throw new IllegalArgumentException("Unknown ViewModel class in weekly");
    }
}


