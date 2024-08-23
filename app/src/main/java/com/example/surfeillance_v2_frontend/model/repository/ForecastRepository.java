package com.example.surfeillance_v2_frontend.model.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;
import com.example.surfeillance_v2_frontend.model.DAO.ForecastDAO;
import com.example.surfeillance_v2_frontend.model.data.Forecast;
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
    private final ForecastService forecastService;
    private ForecastDAO forecastDAO;

    String TAG = "forecastrepo";


    public ForecastRepository (Context context){
        SurfeillanceDB db = Room.databaseBuilder(context.getApplicationContext(), SurfeillanceDB.class, "surfeillance").build();
        forecastDAO = db.forecastDAO();
        forecastService = APIClient.getInstance().create(ForecastService.class);
    }

    public void refreshForecastDB(){
        Call<List<Forecast>> call = forecastService.getAllForecasts();

        call.enqueue(new Callback<List<Forecast>>() {
            
            //TODO probably do this ASYNC at some point using threading...
            @Override
            public void onResponse(Call<List<Forecast>> call, Response<List<Forecast>> response) {
                if(response.isSuccessful() && response.body() != null){
                    forecastDAO.insertAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Forecast>> call, Throwable throwable) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }

}
