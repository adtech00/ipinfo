package com.adtech.ipinfo.model.response;

import java.util.Map;

public class IPRes {
    private String ipAddress;
    private Location location;
    private String cityName;
    private String postalCode;
    private Map<String,String> country;
    private Map<String,String> continent;
    private Map<String,String> subdivision;
    private Traits traits;

    public IPRes(String ipAddress){
        this.ipAddress=ipAddress;
    }

    public IPRes(String ipAddress, Location location, String cityName, String postalCode, Map<String,String> country, Map<String, String> continent, Map<String, String> subdivision, Traits traits){
        this.ipAddress=ipAddress;
        this.location=location;
        this.cityName=cityName;
        this.postalCode=postalCode;
        this.country=country;
        this.continent=continent;
        this.subdivision=subdivision;
        this.traits=traits;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Map<String, String> getCountry() {
        return country;
    }

    public void setCountry(Map<String, String> country) {
        this.country = country;
    }

    public Map<String, String> getContinent() {
        return continent;
    }

    public void setContinent(Map<String, String> continent) {
        this.continent = continent;
    }

    public Map<String, String> getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Map<String, String> subdivision) {
        this.subdivision = subdivision;
    }

    public Traits getTraits() {
        return traits;
    }

    public void setTraits(Traits traits) {
        this.traits = traits;
    }

    @Override
    public String toString() {
        return "IPRes{" +
                "ipAddress='" + ipAddress + '\'' +
                ", location=" + location +
                ", cityName='" + cityName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", continent=" + continent +
                ", subdivision=" + subdivision +
                ", traits=" + traits +
                '}';
    }
}
