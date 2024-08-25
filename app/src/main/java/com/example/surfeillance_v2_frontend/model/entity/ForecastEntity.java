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
    private Long spotId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "latitude")
    private double latitude;

    @ColumnInfo(name = "longitude")
    private double longitude;

    @ColumnInfo(name = "beach_facing")
    private Double beachFacing;

    @ColumnInfo(name = "creation_time")
    private String creationTime;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "wave_direction")
    private Double waveDirection;

    @ColumnInfo(name = "wave_height")
    private double waveHeight;

    @ColumnInfo(name = "wave_period")
    private Double wavePeriod;

    @ColumnInfo(name = "wind_direction")
    private Double windDirection;

    @ColumnInfo(name = "wind_gusts")
    private double windGusts;

    @ColumnInfo(name = "wind_speed")
    private double windSpeed;

   /* public ForecastEntity(int id, String spotId, String name, double latitude, double longitude, String creationTime, String date, String time, String waveDirection, double waveHeight, int wavePeriod, String windDirection, double windGusts, double windSpeed) {
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
    }*/

    public ForecastEntity(Long spotId, String name, double latitude, double longitude, Double beachFacing, String creationTime, String date, String time, Double waveDirection, double waveHeight, Double wavePeriod, Double windDirection, double windGusts, double windSpeed) {
        this.spotId = spotId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.beachFacing = beachFacing;
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

    public Long getSpotId() {
        return spotId;
    }

    public void setSpotId(Long spotId) {
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

    public Double getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(Double waveDirection) {
        this.waveDirection = waveDirection;
    }

    public double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(double waveHeight) {
        this.waveHeight = waveHeight;
    }

    public Double getWavePeriod() {
        return wavePeriod;
    }

    public void setWavePeriod(Double wavePeriod) {
        this.wavePeriod = wavePeriod;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Double windDirection) {
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

    public Double getBeachFacing() {
        return beachFacing;
    }

    public void setBeachFacing(Double beachFacing) {
        this.beachFacing = beachFacing;
    }

    @Override
    public String toString() {
        return "ForecastEntity{" +
                "id=" + id +
                ", spotId=" + spotId +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", beachFacing=" + beachFacing +
                ", creationTime='" + creationTime + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", waveDirection='" + waveDirection + '\'' +
                ", waveHeight=" + waveHeight +
                ", wavePeriod=" + wavePeriod +
                ", windDirection='" + windDirection + '\'' +
                ", windGusts=" + windGusts +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
