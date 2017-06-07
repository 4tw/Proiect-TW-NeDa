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

    void updateNumberByDistrict(String district, int newNumber);

    void updateDistrictName(HousesDestroyed housesDestroyed, String district);

    List<HousesDestroyed> getByGeoRegion(String geoRegion);

    List<HousesDestroyed> getbyDevReg(String devReg);

    List<HousesDestroyed> getByDistrict(String district);

    List<HousesDestroyed> getById(int id);

    List<Object[]> getSimpleResultByZone(String zone);
}
