package com.example.surfeillance_v2_frontend.service.util;

import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;

public class OnshoreOffshore {

    public Boolean windIsOffshore(ForecastEntity forecast) {

        Double offshoreMinimum = 100.0;

        Double difference = Math.abs(forecast.getBeachFacing() - forecast.getWindDirection());
        if (difference >= 180) {
            difference = 360 - difference;
        }
        return difference <= offshoreMinimum;
    }

    public Boolean wavesAreOnshore(ForecastEntity forecast) {

        Double degreesAwayFromDirectMin = 75D;
        Double difference = Math.abs(forecast.getWaveDirection() - forecast.getBeachFacing());

        if(difference >= 180){
            difference = 360 - difference;
        }

        return difference > degreesAwayFromDirectMin;
    }

}
