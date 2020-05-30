package com.adtech.ipinfo.service;

import com.adtech.ipinfo.model.IpInfo;

import java.util.List;

public interface IpInfoService {
    public IpInfo save(IpInfo ipInfo);
    public IpInfo getById(Long ipInfoId);
    public List<IpInfo> getByCity(String city);
    public List<IpInfo> getAll();
}
