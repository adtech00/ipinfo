package com.adtech.ipinfo.model.response;

import com.maxmind.geoip2.model.ConnectionTypeResponse.ConnectionType;

public class Traits {
    private Integer autonomousSystemNumber;
    private String autonomousSystemOrganization;
    private String connectionType;
    private String domain;
    private String ipAddress;
    private boolean isAnonymousProxy;
    private boolean isSatelliteProvider;
    private String isp;
    private String organization;
    private String userType;
    private boolean isLegitimateProxy;

    public Traits(com.maxmind.geoip2.record.Traits traits) {
        this.autonomousSystemNumber = traits.getAutonomousSystemNumber();
        this.autonomousSystemOrganization = traits.getAutonomousSystemOrganization();
        this.connectionType = traits.getConnectionType().toString();
        this.domain = traits.getDomain();
        this.ipAddress = traits.getIpAddress();
        this.isAnonymousProxy = traits.isAnonymousProxy();
        this.isSatelliteProvider = traits.isSatelliteProvider();
        this.isp = traits.getIsp();
        this.organization = traits.getOrganization();
        this.userType = traits.getUserType();
        this.isLegitimateProxy = traits.isLegitimateProxy();
    }

    public Integer getAutonomousSystemNumber() {
        return autonomousSystemNumber;
    }

    public void setAutonomousSystemNumber(Integer autonomousSystemNumber) {
        this.autonomousSystemNumber = autonomousSystemNumber;
    }

    public String getAutonomousSystemOrganization() {
        return autonomousSystemOrganization;
    }

    public void setAutonomousSystemOrganization(String autonomousSystemOrganization) {
        this.autonomousSystemOrganization = autonomousSystemOrganization;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isAnonymousProxy() {
        return isAnonymousProxy;
    }

    public void setAnonymousProxy(boolean anonymousProxy) {
        isAnonymousProxy = anonymousProxy;
    }

    public boolean isSatelliteProvider() {
        return isSatelliteProvider;
    }

    public void setSatelliteProvider(boolean satelliteProvider) {
        isSatelliteProvider = satelliteProvider;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isLegitimateProxy() {
        return isLegitimateProxy;
    }

    public void setLegitimateProxy(boolean legitimateProxy) {
        isLegitimateProxy = legitimateProxy;
    }

    @Override
    public String toString() {
        return "Traits{" +
                "autonomousSystemNumber=" + autonomousSystemNumber +
                ", autonomousSystemOrganization='" + autonomousSystemOrganization + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", domain='" + domain + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", isAnonymousProxy=" + isAnonymousProxy +
                ", isSatelliteProvider=" + isSatelliteProvider +
                ", isp='" + isp + '\'' +
                ", organization='" + organization + '\'' +
                ", userType='" + userType + '\'' +
                ", isLegitimateProxy=" + isLegitimateProxy +
                '}';
    }
}
