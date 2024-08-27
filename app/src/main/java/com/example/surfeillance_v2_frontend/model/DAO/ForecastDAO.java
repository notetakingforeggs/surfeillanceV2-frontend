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

    // get first decent
    @Query("SELECT * FROM forecasts f WHERE f.is_decent = 1 AND f.id = (SELECT MIN(f2.id) FROM forecasts f2 WHERE f2.spot_id = f.spot_id AND f2.is_decent = 1)")
    LiveData<List<ForecastEntity>> getEarliestDecentForecastPerSpot();




    // TODO search queries in here for later

}
