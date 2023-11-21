package com.qta.be.service.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.InetAddress;

@Component
public class GeoLocationHelper {

    private final String DB_PATH = "/Users/alextian/work/iot/GeoLite2-City.mmdb";


    public String getCity(String ip) throws Exception {
        File database = new File(DB_PATH);
        DatabaseReader dbReader = new DatabaseReader.Builder(database)
                .build();

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String countryName = response.getCountry().getName();
        String cityName = response.getCity().getName();
        String postal = response.getPostal().getCode();
        String state = response.getLeastSpecificSubdivision().getName();
        System.out.println(countryName);
        System.out.println(cityName);
        System.out.println(postal);
        System.out.println(state);
        return cityName;
    }
}
