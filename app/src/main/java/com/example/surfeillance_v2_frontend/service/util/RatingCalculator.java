package com.example.surfeillance_v2_frontend.service.util;

import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;

public class RatingCalculator {
    private OnshoreOffshore onshoreOffshore;


    // simpled version just a bool
    // this should maybe be on the backend i think.

    public Boolean isDecent(ForecastEntity forecast) {
        Boolean isDecent = false;

        // waves too small
        if (forecast.getWaveHeight() < 0.5) return false;
        // waves too big
        if (forecast.getWaveHeight() > 2.5) return false;
        // too windy in general
        if (forecast.getWindSpeed() > 30) return false;
        // too windy offshore
        if (onshoreOffshore.windIsOffshore(forecast) && forecast.getWindSpeed() > 35) return false;
        // too windy onshore
        if (!onshoreOffshore.windIsOffshore(forecast) && forecast.getWindSpeed() > 15) return false;
        // period too small
        if (forecast.getWavePeriod() < 8) return false;
        // waves are unlikely to be reaching the break.
        if (!onshoreOffshore.wavesAreOnshore(forecast)) return false;

        return true;
    }


}
