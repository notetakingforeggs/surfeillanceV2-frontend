package com.example.surfeillance_v2_frontend.model.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;
import com.example.surfeillance_v2_frontend.model.DAO.ForecastDAO;
import com.example.surfeillance_v2_frontend.model.DTO.ForecastDTO;
import com.example.surfeillance_v2_frontend.model.data.Forecast;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;
import com.example.surfeillance_v2_frontend.service.APIClient;
import com.example.surfeillance_v2_frontend.service.ForecastService;
import com.example.surfeillance_v2_frontend.service.SurfeillanceDB;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

// Lots of unchecked assignments and calls and things to have a look at.

public class ForecastRepository {
    private final MutableLiveData liveData = new MutableLiveData<>();
    private Application app;
    private ForecastService forecastService;
    private ForecastDAO forecastDAO;

    String TAG = "forecastrepo";


    public ForecastRepository(Application app) {
        SurfeillanceDB db = SurfeillanceDB.getDB(app);
        forecastDAO = db.forecastDAO();
        forecastService = APIClient.getInstance().create(ForecastService.class);

        Log.i(TAG, "ForecastRepository: just after retrofuilt creation");
    }

    public void refreshForecastDB() {
        Log.i(TAG, "refreshForecastDB: ");

     /*   Call<List<ForecastDTO>> call = forecastService.getAllForecasts();
       call.enqueue(new Callback<List<ForecastDTO>>() {

            //TODO probably do this ASYNC at some point using threading...
            @Override
            public void onResponse(Call<List<ForecastDTO>> call, Response<List<ForecastDTO>> response) {
                    Log.i(TAG, "onResponse: " + response.body().toString());
//                    forecastDAO.insertAll(response.body());
            }

            @Override
            public void onFailure(Call<List<ForecastDTO>> call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }*/

        Call<String> call = forecastService.getForecastRaw();
        Log.i(TAG, "refreshForecastDB: formed ");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });

    }
}
