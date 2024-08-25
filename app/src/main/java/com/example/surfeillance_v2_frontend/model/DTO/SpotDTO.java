package com.example.surfeillance_v2_frontend.model.DTO;

public class SpotDTO {
    private Long spotId;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double beachFacing;

    public SpotDTO(Long spotId, String name, Double latitude, Double longitude, Double beachFacing) {
        this.spotId = spotId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.beachFacing = beachFacing;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getBeachFacing() {
        return beachFacing;
    }

    public void setBeachFacing(Double beachFacing) {
        this.beachFacing = beachFacing;
    }



    @Override
    public String toString() {
        return "SpotDTO{" +
                "spotId=" + spotId +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", beachFacing=" + beachFacing +
                '}';
    }
}
