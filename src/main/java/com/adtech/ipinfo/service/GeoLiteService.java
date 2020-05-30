package com.adtech.ipinfo.service;

import com.adtech.ipinfo.config.IPInfoConstants;
import com.adtech.ipinfo.model.response.IPRes;
import com.adtech.ipinfo.utils.IpUtils;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.InetAddress;

@Service
public class GeoLiteService {

    @Autowired
    private IPInfoConstants ipInfoConstants;

    @Autowired
    private IpUtils ipUtils;

    public IPRes getDetails(String ip) {
        try {
            String dbLocation = ipInfoConstants.geoLiteDBLocation;
            File database = new File(dbLocation);
            DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
            InetAddress ipAddress = InetAddress.getByName(ip);
            CityResponse response = dbReader.city(ipAddress);

            IPRes ipRes = ipUtils.getIPResString(response);
            System.out.println(ipRes);

            return ipRes;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error Occured...................");
            return new IPRes(ip);
        }
    }
}
