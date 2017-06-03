package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.HousesDestroyed;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
public interface HousesDestroyedDAO {
    void delete(HousesDestroyed housesDestroyed);

    HousesDestroyed update(HousesDestroyed housesDestroyed);

    HousesDestroyed add(HousesDestroyed housesDestroyed);

    List<HousesDestroyed> getAll();

    List<HousesDestroyed> getByGeoRegion(String geoReg);

    List<HousesDestroyed> getByDevReg(String devReg);

    HousesDestroyed getByDistrict(String district);

    List<Object[]> getSimpleResultByZone(String zone);


}
