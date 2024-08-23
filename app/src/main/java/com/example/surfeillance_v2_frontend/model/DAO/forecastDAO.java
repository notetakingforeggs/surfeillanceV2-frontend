package com.example.surfeillance_v2_frontend.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.surfeillance_v2_frontend.model.Forecast;

import java.util.List;

@Dao
public interface forecastDAO {
    @Query("SELECT * FROM forecasts")
    List<Forecast> getAll();

    @Insert
    void insertAll(List<Forecast> forecasts);

    @Query("DELETE FROM forecasts")
    void deleteAll();


    // TODO search queries in here for later

}
