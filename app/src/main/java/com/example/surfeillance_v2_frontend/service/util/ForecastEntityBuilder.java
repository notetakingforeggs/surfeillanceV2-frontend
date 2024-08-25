package com.example.surfeillance_v2_frontend.service.util;

import android.util.Log;
import com.example.surfeillance_v2_frontend.model.DTO.ForecastDTO;
import com.example.surfeillance_v2_frontend.model.DTO.SpotDTO;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;

import java.util.List;
import java.util.stream.Stream;

public class ForecastEntityBuilder {

    private String TAG = "forecastEntityBuilder";

    public ForecastEntity buildForecast(ForecastDTO forecastDTO) {
        ForecastEntity forecastEntity = new ForecastEntity(
                forecastDTO.getSpot().getSpotId(),
                forecastDTO.getSpot().getName(),
                forecastDTO.getSpot().getLatitude(),
                forecastDTO.getSpot().getLongitude(),
                forecastDTO.getSpot().getBeachFacing(),
                forecastDTO.getCreationTime(),
                forecastDTO.getDate(),
                forecastDTO.getTime(),
                forecastDTO.getWaveDirection(),
                forecastDTO.getWaveHeight(),
                forecastDTO.getWavePeriod(),
                forecastDTO.getWindDirection(),
                forecastDTO.getWindGusts(),
                forecastDTO.getWindSpeed(),
                forecastDTO.getDecent()
        );
        return forecastEntity;
    }
}
