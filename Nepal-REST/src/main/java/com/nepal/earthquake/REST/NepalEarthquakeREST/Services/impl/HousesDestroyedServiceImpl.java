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
        List<HousesDestroyed> housesDestroyed = housesDestroyedDAO.getByDistrict(district);
        for(HousesDestroyed h : housesDestroyed)
            housesDestroyedDAO.delete(h);
    }

    @Override
    public void updateNumberByDistrict(String district, int newNumber) {
        List<HousesDestroyed> housesDestroyed = housesDestroyedDAO.getByDistrict(district);
        for(HousesDestroyed h : housesDestroyed){
            h.setNumber(newNumber);

            housesDestroyedDAO.update(h);
        }

    }

    @Override
    public void updateDistrictName(HousesDestroyed housesDestroyed, String district) {
        housesDestroyed.setDistrict(district);

        housesDestroyedDAO.update(housesDestroyed);

    }

    @Override
    public List<HousesDestroyed> updateCoordinatesByDistrict(String district, Float latitude, Float longitude) {
        List<HousesDestroyed> entriesToBeUpdated = housesDestroyedDAO.getByDistrict(district);

        for(HousesDestroyed h : entriesToBeUpdated){
            h.setLatitude(latitude);
            h.setLongitude(longitude);

            housesDestroyedDAO.update(h);
        }

        return entriesToBeUpdated;
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
    public List<HousesDestroyed> getByDistrict(String district) {
        return housesDestroyedDAO.getByDistrict(district);
    }

    @Override
    public List<HousesDestroyed> getById(int id) {
        return null;
    }

    @Override
    public List<Object[]> getSimpleResultByZone(String zone) {
        return housesDestroyedDAO.getSimpleResultByZone(zone);
    }
}
