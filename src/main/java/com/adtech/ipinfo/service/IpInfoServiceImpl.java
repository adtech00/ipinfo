package com.adtech.ipinfo.service;

import com.adtech.ipinfo.model.IpInfo;
import com.adtech.ipinfo.repository.IpInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpInfoServiceImpl implements IpInfoService{

    @Autowired
    private IpInfoRepository ipInfoRepository;


    @Override
    public IpInfo save(IpInfo ipInfo) {
        return ipInfoRepository.save(ipInfo);
    }

    @Override
    public IpInfo getById(Long ipInfoId) {
        return ipInfoRepository.findByID(ipInfoId);
    }

    @Override
    public List<IpInfo> getByCity(String city) {
        return ipInfoRepository.findByCity(city);
    }

    @Override
    public List<IpInfo> getAll() {
        return ipInfoRepository.findAll();
    }
}
