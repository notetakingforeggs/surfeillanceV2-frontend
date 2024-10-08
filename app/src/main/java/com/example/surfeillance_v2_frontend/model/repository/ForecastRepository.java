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

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

// Lots of unchecked assignments and calls and things to have a look at.

public class ForecastRepository {
    // Logging Tag
    String TAG = "forecastrepo";

    // utils/tools
    private ForecastService forecastService;
    private ForecastDAO forecastDAO;
    private ForecastEntityBuilder forecastEntityBuilder;
    private final ExecutorService executor = AppExecutors.getInstance().database();

    // params
    private long spotId;
    private Application app;
    private String date;
    // hard coding list of spot ids but in future this will be taken either from profile preferences, or x closest spots.
    // imaginging at some point having the ability to send a list of spot ids into the DAO and it will bring back live data for only those spots, but later..
    private List<Long> spotIds = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    // TODO later this format would be good ot refactor into the daily forecast to enable daylight forecasts only
    private List<String> simpleTimes = Arrays.asList("06:00", "12:00", "18:00");

    // return data
    private LiveData<List<ForecastEntity>> forecastsLiveData;
    private LiveData<List<ForecastEntity>> firstDecentsLiveData;
    private LiveData<List<ForecastEntity>> simpleDayForecasts;
    private LiveData<List<ForecastEntity>> hourlyForecastsAtSpotOnDate;
    private List<ForecastEntity> forecastEntities;


    // basic constructor - main
    public ForecastRepository(Application app) {
        SurfeillanceDB db = SurfeillanceDB.getDB(app);
        forecastDAO = db.forecastDAO();
        firstDecentsLiveData = forecastDAO.getEarliestDecentForecastPerSpot();

        forecastService = APIClient.getInstance().create(ForecastService.class);

        Log.i(TAG, "ForecastRepository: just after retrofuilt creation");
    }

    // constructor with spot - week forecasts
    public ForecastRepository(Application app, long spotId) {
        SurfeillanceDB db = SurfeillanceDB.getDB(app);
        forecastDAO = db.forecastDAO();
        simpleDayForecasts = forecastDAO.getSimpleDayForecast(spotId, this.simpleTimes);
    }

 // constructor with spot and date - day forecasts
    public ForecastRepository(Application app, long spotId, String date) {
        SurfeillanceDB db = SurfeillanceDB.getDB(app);
        forecastDAO = db.forecastDAO();
        hourlyForecastsAtSpotOnDate = forecastDAO.getHourlyForecastsAtSpotOnDate(spotId, date);
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
                        forecastDAO.deleteAll();
                        forecastDAO.insertAll(forecastEntities);
                        List<String> test = forecastDAO.getNamesOfForecastSpots();
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

    // dont need params as constructor takes spot id so forecast live data is already for the spot and there for the taking.
    public LiveData<List<ForecastEntity>> getForecastsLiveDataBySpotId() {
        return forecastsLiveData;
    }

    public LiveData<List<ForecastEntity>> getSimpleDayForecasts(){ return simpleDayForecasts;}

    public LiveData<List<ForecastEntity>> getFirstDecentsLiveData()
    {
        return firstDecentsLiveData;
    }

    public LiveData<List<ForecastEntity>> getHourlyForecastsAtSpotOnDate() { return hourlyForecastsAtSpotOnDate;}

}

