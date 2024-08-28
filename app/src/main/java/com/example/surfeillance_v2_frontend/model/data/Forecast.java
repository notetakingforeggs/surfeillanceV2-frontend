package com.example.surfeillance_v2_frontend.model.data;
// TODO decide whether it makes sense to use this class at all? i think i can just use the entity class for now.


public class Forecast {

    private String spotId;
    private String name;
    private double latitude;
    private double longitude;
    private Double beachFacing;

    private String creationTime;
    private String date;
    private String time;
    private Double waveHeight;
    private Double waveDirection;
    private Double wavePeriod;
    private Double windSpeed;
    private Double windDirection;
    private Double windGusts;



    public Forecast(String spotId, String name, double latitude, double longitude, Double beachFacing, String creationTime, String date, String time, Double waveHeight, Double waveDirection, Double wavePeriod, Double windSpeed, Double windDirection, Double windGusts) {
        this.spotId = spotId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.beachFacing = beachFacing;
        this.creationTime = creationTime;
        this.date = date;
        this.time = time;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.windGusts = windGusts;
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

    public Double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(Double waveHeight) {
        this.waveHeight = waveHeight;
    }

    public Double getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(Double waveDirection) {
        this.waveDirection = waveDirection;
    }

    public Double getWavePeriod() {
        return wavePeriod;
    }

    public void setWavePeriod(Double wavePeriod) {
        this.wavePeriod = wavePeriod;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindGusts() {
        return windGusts;
    }

    public void setWindGusts(Double windGusts) {
        this.windGusts = windGusts;
    }

    public Double getBeachFacing() {
        return beachFacing;
    }

    public void setBeachFacing(Double beachFacing) {
        this.beachFacing = beachFacing;
    }
}