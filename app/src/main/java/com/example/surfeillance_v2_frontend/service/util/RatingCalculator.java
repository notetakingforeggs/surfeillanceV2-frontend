package com.example.surfeillance_v2_frontend.service.util;

import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;

public class RatingCalculator {
    private OnshoreOffshore wind;


public Boolean isDecent(ForecastEntity forecast){
    Boolean isDecent = false;


    if(forecast.getWaveHeight()<0.5) return false;
    if(forecast.getWaveHeight()>2.5) return false;
    if(forecast.getWindSpeed() > 30) return false;
    if(wind.isOffshore(forecast) && forecast.getWindSpeed()>35) return false;
    if(!wind.isOffshore(forecast) && forecast.getWindSpeed()>15) return false;
    if(forecast.getWavePeriod() < 8 ) return false;
    if ()

}


}
