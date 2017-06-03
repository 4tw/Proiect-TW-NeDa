package com.nepal.earthquake.REST.NepalEarthquakeREST.Services;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadWomen;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
public interface DeadWomenService {

    List<DeadWomen> getAll();

    DeadWomen add(DeadWomen deadWomen);

    void removeByDistrict(String district);

    DeadWomen updateNumberByDistrict(String district, int newNumber);

    DeadWomen updateDistrictName(String oldDistrictName, String newDistrictName);

    List<DeadWomen> getByGeoRegion(String geoRegion);

    List<DeadWomen> getbyDevReg(String devReg);

    DeadWomen getByDistrict(String district);

    DeadWomen getById(int id);

    List<Object[]> getSimpleResultByDevRegn(String devReg);
}
