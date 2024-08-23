package com.example.surfeillance_v2_frontend.model.repository;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillance_v2_frontend.model.data.Forecast;
import com.example.surfeillance_v2_frontend.service.APIClient;
import com.example.surfeillance_v2_frontend.service.ForecastService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

// Lots of unchecked assignments and calls and things to have a look at.

public class ForecastRepository {
    private final MutableLiveData liveData = new MutableLiveData<>();
    private Application app;
    private final ForecastService forecastService;
    String TAG = "forecastrepo";

    public ForecastRepository (Application app){
        this.app = app;
        forecastService = APIClient.getInstance().create(ForecastService.class);
    }

    public MutableLiveData<List<Forecast>> getMutableLiveData(){
        Call call = forecastService.getAllForecasts();
        call.enqueue(new Callback<List<Forecast>>() {
            @Override
            public void onResponse(Call<List<Forecast>> call, Response<List<Forecast>> response) {
                List<Forecast> forecasts = response.body();
                liveData.setValue(forecasts);
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });

        return liveData;
    }

}
