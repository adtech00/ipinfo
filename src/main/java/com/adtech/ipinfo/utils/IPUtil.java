package com.adtech.ipinfo.utils;

import com.adtech.ipinfo.model.response.IPRes;
import com.adtech.ipinfo.model.response.Location;
import com.adtech.ipinfo.model.response.Traits;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IPUtil {
    public IPRes getIPResString(CityResponse cityResponse){

        Location location = new Location(cityResponse.getLocation());
        Traits traits=null;
        if (cityResponse.getTraits()!=null)
             traits = new Traits(cityResponse.getTraits());

        Map<String, String> countryMap = new HashMap<String, String>(){{
            put(cityResponse.getCountry().getIsoCode(), cityResponse.getCountry().getName());
        }};
        Map<String, String> continentMap = new HashMap<String, String>(){{
            put(cityResponse.getContinent().getCode(), cityResponse.getContinent().getName());
        }};
        Map<String, String> subdivisionMap = new HashMap<String, String>(){{
            put(cityResponse.getSubdivisions().get(0).getIsoCode(), cityResponse.getSubdivisions().get(0).getName());
        }};

        return new IPRes(cityResponse.getTraits().getIpAddress(), location, cityResponse.getCity().getName(), cityResponse.getPostal().getCode(), countryMap, continentMap, subdivisionMap, traits);
    }
}
