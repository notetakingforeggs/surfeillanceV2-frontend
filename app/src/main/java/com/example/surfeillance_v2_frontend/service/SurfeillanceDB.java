package com.example.surfeillance_v2_frontend.service;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.surfeillance_v2_frontend.model.DAO.ForecastDAO;
import com.example.surfeillance_v2_frontend.model.data.Forecast;

@Database(entities = {Forecast.class}, version = 1)
public abstract class SurfeillanceDB extends RoomDatabase {
    public abstract ForecastDAO forecastDAO();
}
