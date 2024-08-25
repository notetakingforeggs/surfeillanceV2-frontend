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
    @Query("SELECT *\n" +
            "FROM forecasts AS t1\n" +
            "WHERE id = (\n" +
            "    SELECT MIN(id)\n" +
            "    FROM forecasts AS t2\n" +
            "    WHERE t1.name = t2.name\n" +
            "      AND t2.is_decent = 1\n" +
            ");"
    )
    LiveData<List<ForecastEntity>> getFirstDecents();


    // TODO search queries in here for later

}
