package com.nepal.earthquake.REST.NepalEarthquakeREST.Services.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadMen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DeadMenService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadMenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
@Service
public class DeadMenServiceImpl implements DeadMenService {

    @Autowired
    private DeadMenDAO deadMenDAO;

    @Override
    public List<DeadMen> getAll() {
        return deadMenDAO.getAll();
    }

    @Override
    public DeadMen add(DeadMen deadMen) {
        deadMenDAO.add(deadMen);
        return deadMen;
    }

    @Override
    public void removeByDistrict(String district) {
        List<DeadMen> deadMen = deadMenDAO.getByDistrict(district);

        for(DeadMen d : deadMen)
            deadMenDAO.delete(d);
    }

    @Override
    public void updateNumberByDistrict(String district, int newNumber) {
        List<DeadMen> updatedRecord = deadMenDAO.getByDistrict(district);

        for(DeadMen d : updatedRecord){
            d.setNumber(newNumber);

            deadMenDAO.update(d);
        }

    }

    @Override
    public void updateDistrictName(DeadMen deadMen, String district) {
        DeadMen updatedRecord = deadMen;
        updatedRecord.setDistrict(district);

        deadMenDAO.update(updatedRecord);
    }

    @Override
    public List<DeadMen> getByGeoRegion(String geoRegion) {
        return deadMenDAO.getByGeoRegion(geoRegion);
    }

    @Override
    public List<DeadMen> getbyDevReg(String devReg) {
        return deadMenDAO.getbyDevReg(devReg);
    }

    @Override
    public List<DeadMen> getByDistrict(String district) {
        return deadMenDAO.getByDistrict(district);
    }

    @Override
    public List<DeadMen> getById(int id) {
        return deadMenDAO.getById(id);
    }

    @Override
    public List<Object[]> getSimpleResultByDevRegn(String devReg) {
        return deadMenDAO.getSimpleResultByDevRegn(devReg);
    }
}
