package com.example.surfeillance_v2_frontend.viewmodels;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.surfeillance_v2_frontend.model.DAO.ForecastDAO;
import com.example.surfeillance_v2_frontend.model.data.Forecast;
import com.example.surfeillance_v2_frontend.model.repository.ForecastRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private ForecastRepository forecastRepository;
     private ForecastDAO forecastDAO;
      private MutableLiveData<List<String>> data;
      public String TAG = "MainActivityViewModel";

    public MainActivityViewModel(Application application) {
        super(application);
        data = new MutableLiveData<>();
        forecastRepository = new ForecastRepository(application);
    }

    public void refreshLocalDB() {
        Log.i(TAG, "refreshLocalDB: ");
        forecastRepository.refreshForecastDB();
    }

    public LiveData<List<String>> getSampleForecastsFromRoom() {
        new Thread(() -> {
            List<String> forecasts = forecastDAO.getNamedOfForecastSpots();
            data.postValue(forecasts);
        }).start();
        return data;
    }
}
