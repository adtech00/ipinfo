package com.adtech.ipinfo.webservice;

import com.adtech.ipinfo.model.IpInfo;
import com.adtech.ipinfo.model.response.IPRes;
import com.adtech.ipinfo.service.GeoLiteService;
import com.adtech.ipinfo.utils.IpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IPResource {

    @Autowired
    private GeoLiteService geoLiteService;

    @Autowired
    private IpUtils ipUtils;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/ip" , method = RequestMethod.GET)
    public String ipInfo(HttpServletRequest httpServletRequest){

        String ip = ipUtils.getIpAddress(httpServletRequest);
        if (ipUtils.stringEmpty(ip)){
            //Throw Exception
        }

        IPRes ipRes = geoLiteService.getDetails(ip.split(":>>>")[1].trim());
        if (ipRes==null){
            //Throw Exception
        }

        //Save to DB
        try{
            IpInfo ipInfo = ipUtils.saveToDB(ipRes);
            if (ipInfo==null){
                logger.error("Unable to Save in DB");
            }
        }catch (Exception e){
            logger.error("Exception Occured While Saving IP Information into DB");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            String ipResponse = mapper.writeValueAsString(ipRes);
            if (ipResponse.trim().equals("{}"))ipResponse=ipRes.toString();
            return ipResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ipRes.toString();
        }
    }
}
