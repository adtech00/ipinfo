package com.adtech.ipinfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IPResource {

    @RequestMapping(value = "/ip" , method = RequestMethod.GET)
    public String ipInfo(HttpServletRequest httpServletRequest){

        String ip0 = httpServletRequest.getHeader("X-Real-IP");
        String ip1 = httpServletRequest.getHeader("X-Forwarded-For");
        String ip2 = httpServletRequest.getRemoteAddr();

        String ipDetails ="X-Real-IP : "+ip0 + "\nX-Forwarded-For : "+ip1 + "\nRemote Addr : "+ip2;



        System.out.println(ipDetails);

        String ipInfo = "";

        if (ip0 != null && !ip0.trim().isEmpty()){
            ipInfo = "X-Real-IP : "+ip0;
        }
        if (ip1 != null && !ip1.trim().isEmpty()){
            ipInfo = (ipInfo.trim() + "\nX-Forwarded-For : "+ip1).trim();
        }
        if (ip2 != null && !ip2.trim().isEmpty()){
            ipInfo = (ipInfo.trim() + "\nRemote Addr : "+ip2).trim();
        }

        if (ipInfo.trim().isEmpty()){
            ipInfo = "Not Found";
        }

        return ipInfo;
    }
}
