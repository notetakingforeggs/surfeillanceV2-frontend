package com.example.surfeillance_v2_frontend;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "surfeillance.db";
    private static final String TABLE_NAME = "forecasts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SPOT_ID = "spot_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_CREATION_TIME = "creation_time";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_WAVE_DIRECTION = "wave_direction";
    private static final String COLUMN_WAVE_HEIGHT = "wave_height";
    private static final String COLUMN_WAVE_PERIOD = "wave_period";
    private static final String COLUMN_WIND_DIRECTION = "wind_direction";
    private static final String COLUMN_WIND_GUSTS = "wind_gusts";
    private static final String COLUMN_WIND_SPEED = "wind_speed";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_SPOT_ID + " INTEGER NOT NULL, "
                    + COLUMN_NAME + " TEXT NOT NULL, "
                    + COLUMN_LATITUDE + " REAL NOT NULL, "
                    + COLUMN_LONGITUDE + " REAL NOT NULL, "
                    + COLUMN_CREATION_TIME + " TEXT NOT NULL, "
                    + COLUMN_DATE + " TEXT NOT NULL, "
                    + COLUMN_TIME + " TEXT NOT NULL, "
                    + COLUMN_WAVE_DIRECTION + " INTEGER, "
                    + COLUMN_WAVE_HEIGHT + " REAL, "
                    + COLUMN_WAVE_PERIOD + " REAL, "
                    + COLUMN_WIND_DIRECTION + " TEXT, "
                    + COLUMN_WIND_GUSTS + " REAL, "
                    + COLUMN_WIND_SPEED + " REAL"
                    + ");";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
