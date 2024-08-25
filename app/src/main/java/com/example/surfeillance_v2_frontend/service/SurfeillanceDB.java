package com.example.surfeillance_v2_frontend.service;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.surfeillance_v2_frontend.model.DAO.ForecastDAO;
import com.example.surfeillance_v2_frontend.model.data.Forecast;
import com.example.surfeillance_v2_frontend.model.entity.ForecastEntity;

@Database(entities = {ForecastEntity.class}, version = 3, exportSchema = false)
public abstract class SurfeillanceDB extends RoomDatabase {

    public abstract ForecastDAO forecastDAO();

    //make the db a singleton
    private static volatile SurfeillanceDB INSTANCE;

    // read more about the doubl locking pattern here
    // https://wiki.sei.cmu.edu/confluence/display/java/LCK10-J.+Use+a+correct+form+of+the+double-checked+locking+idiom#:~:text=The%20double%2Dchecked%20locking%20pattern,reference%20check%20before%20attempting%20synchronization.
    // to help with creating the db when there are async processes, to avoid it happening twice?
    public static SurfeillanceDB getDB(final Context context) {
        if (INSTANCE == null) {
            synchronized (SurfeillanceDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SurfeillanceDB.class, "surfeillance_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
