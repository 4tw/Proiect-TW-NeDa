package com.nepal.earthquake.REST.NepalEarthquakeREST.Services;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.HousesDestroyed;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
public interface HousesDestroyedService {

    List<HousesDestroyed> getAll();

    HousesDestroyed add(HousesDestroyed housesDestroyed);

    void removeByDistrict(String district);

    HousesDestroyed updateNumberByDistrict(String district, int newNumber);

    HousesDestroyed updateDistrictName(HousesDestroyed housesDestroyed, String district);

    List<HousesDestroyed> getByGeoRegion(String geoRegion);

    List<HousesDestroyed> getbyDevReg(String devReg);

    HousesDestroyed getByDistrict(String district);

    HousesDestroyed getById(int id);

    List<Object[]> getSimpleResultByZone(String zone);
}
