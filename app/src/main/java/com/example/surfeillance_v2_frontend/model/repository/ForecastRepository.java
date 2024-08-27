package com.example.surfeillance_v2_frontend.model.repository;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

// Lots of unchecked assignments and calls and things to have a look at.

public class ForecastRepository {
    //    private final LiveData<List<ForecastEntity>> forecastsLiveData;
    private final LiveData<List<ForecastEntity>> firstDecentsLiveData;
    private Application app;
    private ForecastService forecastService;
    private ForecastDAO forecastDAO;
    private ForecastEntityBuilder forecastEntityBuilder;
    private List<ForecastEntity> forecastEntities;
    private final ExecutorService executor = AppExecutors.getInstance().database();

    // hard coding list of spot ids but in future this will be taken either from profile preferences, or x closest spots.
    // imaginging at some point having the ability to send a list of spot ids into the DAO and it will bring back live data for only those spots, but later..
    private List<Long> spotIds = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);

    String TAG = "forecastrepo";


    public ForecastRepository(Application app) {
        SurfeillanceDB db = SurfeillanceDB.getDB(app);
        forecastDAO = db.forecastDAO();
//        forecastsLiveData = forecastDAO.getAll();
        firstDecentsLiveData = forecastDAO.getEarliestDecentForecastPerSpot();

        forecastService = APIClient.getInstance().create(ForecastService.class);

        Log.i(TAG, "ForecastRepository: just after retrofuilt creation");
    }

    public void retrieveForecastsFromBackend() {

        Call<List<ForecastDTO>> call = forecastService.getAllForecasts();
        call.enqueue(new Callback<List<ForecastDTO>>() {

            @Override
            public void onResponse(Call<List<ForecastDTO>> call, Response<List<ForecastDTO>> response) {
                Log.i(TAG, "onResponse: " + response.body().toString());
                forecastEntityBuilder = new ForecastEntityBuilder();
                forecastEntities = response.body().stream()
                        .map(forecastEntityBuilder::buildForecast)
                        .collect(Collectors.toList());
                Log.i(TAG, "onResponse: forecast entities created");

                Log.i(TAG, "updateDB: ");
                if (forecastEntities != null) {
                    Log.i(TAG, "updateDB: inside if block");
                    executor.execute(() -> {
                        forecastDAO.insertAll(forecastEntities);
                        List<String> test = forecastDAO.getNamedOfForecastSpots();
                        test.stream()
                                .forEach(str -> Log.i(TAG, str));
                    });
                }

            }

            @Override
            public void onFailure(Call<List<ForecastDTO>> call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }

//    public LiveData<List<ForecastEntity>> getForecastsLiveData() {
//        return forecastsLiveData;
//    }

    public LiveData<List<ForecastEntity>> getFirstDecentsLiveData() {
        return firstDecentsLiveData;
    }
}

