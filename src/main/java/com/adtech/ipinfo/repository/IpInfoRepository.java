package com.adtech.ipinfo.repository;

import com.adtech.ipinfo.model.IpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IpInfoRepository extends JpaRepository<IpInfo, Serializable> {
    public IpInfo findByID(Long ipInfoId);
    public List<IpInfo> findByCity(String city);
}
