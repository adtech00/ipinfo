package com.adtech.ipinfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IPResource {

    @RequestMapping(value = "/ip" , method = RequestMethod.GET)
    public String ipInfo(HttpServletRequest httpServletRequest){

        String addr0 = httpServletRequest.getHeader("X-Real-IP");
        String addr1 = httpServletRequest.getHeader("X-Forwarded-For");
        String addr2 = httpServletRequest.getRemoteAddr();

        String ipInfo = String.format("X-Real-IP : "+addr0
                +"\nX-Forwarded-For : "+addr1
                +"\nRemote Addr : "+addr2);

        System.out.println(ipInfo);
        return ipInfo;
    }
}
