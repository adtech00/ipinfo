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
