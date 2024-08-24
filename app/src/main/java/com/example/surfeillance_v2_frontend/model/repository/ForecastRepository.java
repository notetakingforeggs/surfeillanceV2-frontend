package com.example.surfeillance_v2_frontend.model.repository;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.surfeillance_v2_frontend.model.DAO.ForecastDAO;
import com.example.surfeillance_v2_frontend.model.DTO.ForecastDTO;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.service.APIClient;
import com.example.surfeillance_v2_frontend.service.ForecastService;
import com.example.surfeillance_v2_frontend.service.SurfeillanceDB;
import com.example.surfeillance_v2_frontend.service.util.AppExecutors;
import com.example.surfeillance_v2_frontend.service.util.ForecastEntityBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

// Lots of unchecked assignments and calls and things to have a look at.

public class ForecastRepository {
    private final LiveData<List<ForecastEntity>> forecastsLiveData;
    private Application app;
    private ForecastService forecastService;
    private ForecastDAO forecastDAO;
    private ForecastEntityBuilder forecastEntityBuilder;
    private List<ForecastEntity> forecastEntities;
    private final ExecutorService executor = AppExecutors.getInstance().database();

    String TAG = "forecastrepo";


    public ForecastRepository(Application app) {
        SurfeillanceDB db = SurfeillanceDB.getDB(app);
        forecastDAO = db.forecastDAO();
        forecastsLiveData = forecastDAO.getAll();

        forecastService = APIClient.getInstance().create(ForecastService.class);

        Log.i(TAG, "ForecastRepository: just after retrofuilt creation");
    }

    public void retrieveForecastsFromBackend() {

        Call<List<ForecastDTO>> call = forecastService.getAllForecasts();
        call.enqueue(new Callback<List<ForecastDTO>>() {

            //TODO probably do this ASYNC at some point using threading...
            @Override
            public void onResponse(Call<List<ForecastDTO>> call, Response<List<ForecastDTO>> response) {
                Log.i(TAG, "onResponse: " + response.body().toString());
                forecastEntityBuilder = new ForecastEntityBuilder();
                forecastEntities = response.body().stream()
                        .map(forecastEntityBuilder::buildForecast)
                        .collect(Collectors.toList());
                Log.i(TAG, "onResponse: forecast entities created");

                Log.i(TAG, "updateDB: ");
                if(forecastEntities!=null) {
                    Log.i(TAG, "updateDB: inside if block");
                    executor.execute(() -> {
                        forecastDAO.insertAll(forecastEntities);
                        List<String> test = forecastDAO.getNamedOfForecastSpots();
                        test.stream()
                                .forEach(str-> Log.i(TAG, str));
                    });
                }

            }

            @Override
            public void onFailure(Call<List<ForecastDTO>> call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }

    public LiveData<List<ForecastEntity>> getForecastsLiveData() {
        return forecastsLiveData;
    }
}

