package com.nepal.earthquake.REST.NepalEarthquakeREST.Services;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadMen;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
public interface DeadMenService {

    List<DeadMen> getAll();

    DeadMen add(DeadMen deadMen);

    void removeByDistrict(String district);

    void updateNumberByDistrict(String district, int newNumber);

    void updateDistrictName(DeadMen deadMen, String district);

    List<DeadMen> getByGeoRegion(String geoRegion);

    List<DeadMen> getbyDevReg(String devReg);

    List<DeadMen> getByDistrict(String district);

    List<DeadMen> getById(int id);

    List<Object[]> getSimpleResultByDevRegn(String devReg);

}
