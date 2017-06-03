package com.nepal.earthquake.REST.NepalEarthquakeREST.Services.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.HousesDestroyed;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.HousesDestroyedService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.HousesDestroyedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
@Service
public class HousesDestroyedServiceImpl implements HousesDestroyedService {

    @Autowired
    private HousesDestroyedDAO housesDestroyedDAO;


    @Override
    public List<HousesDestroyed> getAll() {
        return housesDestroyedDAO.getAll();
    }

    @Override
    public HousesDestroyed add(HousesDestroyed housesDestroyed) {
        housesDestroyedDAO.add(housesDestroyed);
        return housesDestroyed;
    }

    @Override
    public void removeByDistrict(String district) {
        HousesDestroyed housesDestroyed = housesDestroyedDAO.getByDistrict(district);
        housesDestroyedDAO.delete(housesDestroyed);
    }

    @Override
    public HousesDestroyed updateNumberByDistrict(String district, int newNumber) {
        HousesDestroyed housesDestroyed = housesDestroyedDAO.getByDistrict(district);
        housesDestroyed.setNumber(newNumber);

        housesDestroyedDAO.update(housesDestroyed);

        return housesDestroyed;
    }

    @Override
    public HousesDestroyed updateDistrictName(HousesDestroyed housesDestroyed, String district) {
        housesDestroyed.setDistrict(district);

        housesDestroyedDAO.update(housesDestroyed);

        return housesDestroyed;
    }

    @Override
    public List<HousesDestroyed> getByGeoRegion(String geoRegion) {
        return housesDestroyedDAO.getByGeoRegion(geoRegion);
    }

    @Override
    public List<HousesDestroyed> getbyDevReg(String devReg) {
        return housesDestroyedDAO.getByDevReg(devReg);
    }

    @Override
    public HousesDestroyed getByDistrict(String district) {
        return housesDestroyedDAO.getByDistrict(district);
    }

    @Override
    public HousesDestroyed getById(int id) {
        return null;
    }

    @Override
    public List<Object[]> getSimpleResultByZone(String zone) {
        return housesDestroyedDAO.getSimpleResultByZone(zone);
    }
}
