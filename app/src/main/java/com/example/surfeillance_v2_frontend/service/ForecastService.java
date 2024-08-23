package com.example.surfeillance_v2_frontend.service;

import com.example.surfeillance_v2_frontend.model.data.Forecast;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ForecastService {
    @GET("forecast")
    Call<List<Forecast>> getAllForecasts();
}
