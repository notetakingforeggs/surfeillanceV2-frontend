package com.example.surfeillance_v2_frontend.model.DTO;

public class ForecastDTO {
    private Long forecastId;
    private String creationTime;
    private SpotDTO spot;
    private String date;
    private String time;
    private Double waveHeight;
    private String waveDirection;
    private Double wavePeriod;
    private Double windSpeed;
    private String windDirection;
    private Double windGusts;

    public ForecastDTO(Long forecastId, String creationTime, SpotDTO spot, String date, String time, Double waveHeight, String waveDirection, Double wavePeriod, Double windSpeed, String windDirection, Double windGusts) {
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

    public String getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(String waveDirection) {
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

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
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

    @Override
    public String toString() {
        return "ForecastDTO{" +
                "forecastId=" + forecastId +
                ", spot=" + spot +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", waveHeight=" + waveHeight +
                ", waveDirection=" + waveDirection +
                ", wavePeriod=" + wavePeriod +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", windGusts=" + windGusts +
                '}';
    }
}