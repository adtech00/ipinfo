package com.adtech.ipinfo.model.response;

public class Location {
    private Integer accuracyRadius;
    private Integer averageIncome;
    private Double latitude;
    private Double longitude;
    private Integer metroCode;
    private Integer populationDensity;
    private String timeZone;

    public Location(com.maxmind.geoip2.record.Location location){
        this.accuracyRadius = location.getAccuracyRadius();
        this.averageIncome = location.getAverageIncome();
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        this.metroCode = location.getMetroCode();
        this.populationDensity = location.getPopulationDensity();
        this.timeZone = location.getTimeZone();
    }

    public Integer getAccuracyRadius() {
        return accuracyRadius;
    }

    public void setAccuracyRadius(Integer accuracyRadius) {
        this.accuracyRadius = accuracyRadius;
    }

    public Integer getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(Integer averageIncome) {
        this.averageIncome = averageIncome;
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

    public Integer getMetroCode() {
        return metroCode;
    }

    public void setMetroCode(Integer metroCode) {
        this.metroCode = metroCode;
    }

    public Integer getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(Integer populationDensity) {
        this.populationDensity = populationDensity;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "Location{" +
                "accuracyRadius=" + accuracyRadius +
                ", averageIncome=" + averageIncome +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", metroCode=" + metroCode +
                ", populationDensity=" + populationDensity +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
