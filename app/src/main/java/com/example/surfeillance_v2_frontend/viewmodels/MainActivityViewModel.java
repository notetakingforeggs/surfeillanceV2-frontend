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
    private LiveData<List<ForecastEntity>> forecastsLiveData;
    private LiveData<List<ForecastEntity>> firstDecentsLiveData;

    public String TAG = "MainActivityViewModel";

    public MainActivityViewModel(Application application) {
        super(application);
        forecastRepository = new ForecastRepository(application);
        firstDecentsLiveData = forecastRepository.getFirstDecentsLiveData();
    }


    public LiveData<List<ForecastEntity>> getFirstDecentsLiveData() {
        return firstDecentsLiveData;
    }

    public void refreshLocalDB() {
        forecastRepository.retrieveForecastsFromBackend();
    }

}
