package com.example.surfeillance_v2_frontend.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "forecasts")
public class ForecastEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "spot_id")
    private String spotId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "latitude")
    private double latitude;

    @ColumnInfo(name = "longitude")
    private double longitude;

    @ColumnInfo(name = "creation_time")
    private String creationTime;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "wave_direction")
    private String waveDirection;

    @ColumnInfo(name = "wave_height")
    private double waveHeight;

    @ColumnInfo(name = "wave_period")
    private int wavePeriod;

    @ColumnInfo(name = "wind_direction")
    private String windDirection;

    @ColumnInfo(name = "wind_gusts")
    private double windGusts;

    @ColumnInfo(name = "wind_speed")
    private double windSpeed;

    public ForecastEntity(int id, String spotId, String name, double latitude, double longitude, String creationTime, String date, String time, String waveDirection, double waveHeight, int wavePeriod, String windDirection, double windGusts, double windSpeed) {
        this.id = id;
        this.spotId = spotId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.creationTime = creationTime;
        this.date = date;
        this.time = time;
        this.waveDirection = waveDirection;
        this.waveHeight = waveHeight;
        this.wavePeriod = wavePeriod;
        this.windDirection = windDirection;
        this.windGusts = windGusts;
        this.windSpeed = windSpeed;
    }

    public ForecastEntity(String spotId, String name, double latitude, double longitude, String creationTime, String date, String time, String waveDirection, double waveHeight, int wavePeriod, String windDirection, double windGusts, double windSpeed) {
        this.spotId = spotId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.creationTime = creationTime;
        this.date = date;
        this.time = time;
        this.waveDirection = waveDirection;
        this.waveHeight = waveHeight;
        this.wavePeriod = wavePeriod;
        this.windDirection = windDirection;
        this.windGusts = windGusts;
        this.windSpeed = windSpeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(String waveDirection) {
        this.waveDirection = waveDirection;
    }

    public double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(double waveHeight) {
        this.waveHeight = waveHeight;
    }

    public int getWavePeriod() {
        return wavePeriod;
    }

    public void setWavePeriod(int wavePeriod) {
        this.wavePeriod = wavePeriod;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindGusts() {
        return windGusts;
    }

    public void setWindGusts(double windGusts) {
        this.windGusts = windGusts;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
