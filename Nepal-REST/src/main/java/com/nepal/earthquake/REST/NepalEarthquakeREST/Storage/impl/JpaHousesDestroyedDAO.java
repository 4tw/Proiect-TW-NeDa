package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.HousesDestroyed;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.HousesDestroyedDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
public class JpaHousesDestroyedDAO implements HousesDestroyedDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(HousesDestroyed housesDestroyed) {
            entityManager.remove(housesDestroyed);
    }

    @Override
    public void update(HousesDestroyed housesDestroyed) {

    }

    @Override
    public void add(HousesDestroyed housesDestroyed) {

    }

    @Override
    public List<HousesDestroyed> getAll() {
        return null;
    }

    @Override
    public List<HousesDestroyed> getByGeoRegion(String geoReg) {
        return null;
    }

    @Override
    public List<HousesDestroyed> getByDevReg(String devReg) {
        return null;
    }

    @Override
    public List<HousesDestroyed> getByDistrict(String district) {
        return null;
    }
}
