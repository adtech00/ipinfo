package com.adtech.ipinfo.utils;

import com.adtech.ipinfo.model.IpInfo;
import com.adtech.ipinfo.model.response.IPRes;
import com.adtech.ipinfo.model.response.Location;
import com.adtech.ipinfo.model.response.Traits;
import com.adtech.ipinfo.repository.IpInfoRepository;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class IpUtils {

    @Autowired
    private IpInfoRepository ipInfoRepository;


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

        //TODO: Delete It
        try {
            System.out.println(cityResponse.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new IPRes(cityResponse.getTraits().getIpAddress(), location, cityResponse.getCity().getName(), cityResponse.getPostal().getCode(), countryMap, continentMap, subdivisionMap, traits);
    }

    public String getIpAddress(HttpServletRequest httpServletRequest) {

        String ip = "";
        String ip0 = httpServletRequest.getHeader("X-Real-IP");
        String ip1 = httpServletRequest.getHeader("X-Forwarded-For");
        String ip2 = httpServletRequest.getRemoteAddr();

        String ipDetails ="X-Real-IP : "+ip0 + "\nX-Forwarded-For : "+ip1 + "\nRemote Addr : "+ip2;
        System.out.println(ipDetails);

        if (ip0 != null && !ip0.trim().isEmpty()){
            ip = "X-Real-IP :>>> "+ip0;
        }
        if (ip1 != null && !ip1.trim().isEmpty()){
            ip = (ip.trim() + "\nX-Forwarded-For :>>> "+ip1).trim();
        }
        if (ip2 != null && !ip2.trim().isEmpty()){
            ip = (ip.trim() + "\nRemote Addr :>>> "+ip2).trim();
        }
        if (ip.trim().isEmpty()){
            ip = "Not Found";
        }
        return ip;
    }

    public boolean stringNotEmpty(String text) {
        return null != text && !text.trim().isEmpty() && !text.trim().equals("\"\"");
    }

    public boolean stringEmpty(String text) {
        return null == text || text.trim().isEmpty() || text.trim().equals("\"\"");
    }

    public IpInfo saveToDB(IPRes ipRes) {
        IpInfo ipInfo = new IpInfo();
        ipInfo.setIpAddress(ipRes.getIpAddress());
        ipInfo.setLatitude(ipRes.getLocation().getLatitude().longValue());
        ipInfo.setLongitude(ipRes.getLocation().getLongitude().longValue());
        ipInfo.setTimeZone(ipRes.getLocation().getTimeZone());
        ipInfo.setPostalCode(ipRes.getPostalCode());
        ipInfo.setCity(ipRes.getCityName());
        ipInfo.setSubdivision(ipRes.getSubdivision().entrySet().iterator().next().getValue());
        ipInfo.setCountry(ipRes.getCountry().entrySet().iterator().next().getValue());
        ipInfo.setContinent(ipRes.getContinent().entrySet().iterator().next().getValue());

        return ipInfoRepository.save(ipInfo);
    }
}
