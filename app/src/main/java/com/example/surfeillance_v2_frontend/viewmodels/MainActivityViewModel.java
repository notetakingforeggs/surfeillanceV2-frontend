package com.example.surfeillance_v2_frontend.viewmodels;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillance_v2_frontend.model.DAO.ForecastDAO;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.model.repository.ForecastRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private ForecastRepository forecastRepository;
     private ForecastDAO forecastDAO;
     private LiveData<List<ForecastEntity>> forecastsLiveData;
     private LiveData<List<ForecastEntity>> firstDecentsLiveData;

      public String TAG = "MainActivityViewModel";

    public MainActivityViewModel(Application application) {
        super(application);
        forecastRepository = new ForecastRepository(application);
     //   forecastsLiveData = forecastRepository.getForecastsLiveData();
        firstDecentsLiveData = forecastRepository.getFirstDecentsLiveData();

    }

    // kind of like a getter, to be called by view to get the data to present in the UI
    public LiveData<List<ForecastEntity>> getForecastsLiveData(){
        return forecastsLiveData;
    }

    public LiveData<List<ForecastEntity>> getFirstDecentsLiveData(){
        return firstDecentsLiveData;
    }

    // maybe rename? also inserts into local db
    public void refreshLocalDB() {
        Log.i(TAG, "refreshLocalDB: ");
        forecastRepository.retrieveForecastsFromBackend();
    }

}
