package com.spring.todo.services;

import com.maxmind.geoip2.DatabaseReader;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class GeoService extends BaseService {
    public DatabaseReader getGeoDatabase() throws Exception {
        String dbLocation = "C:/Users/admin/Desktop/sample database/GeoLiteCity-data/GeoLiteCity.dat";
        File database = new File(dbLocation);
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
        return dbReader;
    }
}
