package com.example.surfeillance_v2_frontend.model.DTO;

public class ForecastDTO {
    private Long forecastId;
    private String creationTime;
    private SpotDTO spot;
    private String date;
    private String time;
    private Double waveHeight;
    private Double waveDirection;
    private Double wavePeriod;
    private Double windSpeed;
    private Double windDirection;
    private Double windGusts;
    private Boolean isDecent;

    public ForecastDTO(Long forecastId, String creationTime, SpotDTO spot, String date, String time, Double waveHeight, Double waveDirection, Double wavePeriod, Double windSpeed, Double windDirection, Double windGusts, Boolean isDecent) {
        this.forecastId = forecastId;
        this.creationTime = creationTime;
        this.spot = spot;
        this.date = date;
        this.time = time;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.windGusts = windGusts;
        this.isDecent = isDecent;
    }

    public Long getForecastId() {
        return forecastId;
    }

    public void setForecastId(Long forecastId) {
        this.forecastId = forecastId;
    }

    public SpotDTO getSpot() {
        return spot;
    }

    public void setSpot(SpotDTO spot) {
        this.spot = spot;
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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getDecent() {
        return isDecent;
    }

    public void setDecent(Boolean decent) {
        isDecent = decent;
    }

    @Override
    public String toString() {
        return "ForecastDTO{" +
                "forecastId=" + forecastId +
                ", creationTime='" + creationTime + '\'' +
                ", spot=" + spot +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", waveHeight=" + waveHeight +
                ", waveDirection=" + waveDirection +
                ", wavePeriod=" + wavePeriod +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", windGusts=" + windGusts +
                ", isDecent=" + isDecent +
                '}';
    }
}