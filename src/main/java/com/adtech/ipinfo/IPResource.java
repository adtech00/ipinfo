package com.adtech.ipinfo;

import com.adtech.ipinfo.model.response.IPRes;
import com.adtech.ipinfo.service.GeoLiteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IPResource {

    @Autowired
    private GeoLiteService geoLiteService;

   /* @Autowired
    private ObjectMapper mapper;*/

    @RequestMapping(value = "/ip" , method = RequestMethod.GET)
    public String ipInfo(HttpServletRequest httpServletRequest){

        String ip0 = httpServletRequest.getHeader("X-Real-IP");
        String ip1 = httpServletRequest.getHeader("X-Forwarded-For");
        String ip2 = httpServletRequest.getRemoteAddr();

        String ipDetails ="X-Real-IP : "+ip0 + "\nX-Forwarded-For : "+ip1 + "\nRemote Addr : "+ip2;
        System.out.println(ipDetails);

        String ipInfo = "";

        if (ip0 != null && !ip0.trim().isEmpty()){
            ipInfo = "X-Real-IP :>>> "+ip0;
        }
        if (ip1 != null && !ip1.trim().isEmpty()){
            ipInfo = (ipInfo.trim() + "\nX-Forwarded-For :>>> "+ip1).trim();
        }
        if (ip2 != null && !ip2.trim().isEmpty()){
            ipInfo = (ipInfo.trim() + "\nRemote Addr :>>> "+ip2).trim();
        }
        if (ipInfo.trim().isEmpty()){
            ipInfo = "Not Found";
        }

        IPRes ipRes = geoLiteService.getDetails(ipInfo.split(":>>>")[1].trim());
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            /*
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            */

            String ipResponse = mapper.writeValueAsString(ipRes);
            if (ipResponse.trim().equals("{}"))ipResponse=ipRes.toString();
            return ipResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ipRes.toString();
        }
    }
}
