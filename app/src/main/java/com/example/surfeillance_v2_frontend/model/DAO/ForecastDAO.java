package com.example.surfeillance_v2_frontend.model.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.surfeillance_v2_frontend.model.data.Forecast;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;

import java.util.List;

@Dao
public interface ForecastDAO {
    @Query("SELECT * FROM forecasts")
    LiveData<List<ForecastEntity>> getAll();

    @Insert
    void insertAll(List<ForecastEntity> forecasts);

    @Query("DELETE FROM forecasts")
    void deleteAll();

    @Query("SELECT DISTINCT name FROM forecasts ")
    List<String> getNamedOfForecastSpots();


    // TODO search queries in here for later

}
