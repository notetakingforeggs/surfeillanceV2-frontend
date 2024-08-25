package com.example.surfeillance_v2_frontend.service.util;

import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;

public class OnshoreOffshore {

    public Boolean isOffshore(ForecastEntity forecast){

        Double offshoreMinimum = 100.0;
        Double difference = null;

        if(forecast.getWindDirection() > forecast.getBeachFacing()){
             difference = forecast.getWaveDirection()-forecast.getBeachFacing();
        } else if (forecast.getWindDirection() < forecast.getBeachFacing()) {
            difference = forecast.getBeachFacing() - forecast.getWindDirection();
        }

        if (difference >= 180 ){
            difference = 360 - difference;
        }
        return difference <= offshoreMinimum;
    }

}
