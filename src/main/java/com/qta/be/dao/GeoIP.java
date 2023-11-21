package com.qta.be.dao;

import lombok.Data;

@Data
public class GeoIP {
    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
    // constructors, getters and setters...
}