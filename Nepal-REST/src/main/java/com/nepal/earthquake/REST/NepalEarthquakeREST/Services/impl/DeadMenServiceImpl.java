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
        DeadMen deadMen = deadMenDAO.getByDistrict(district);
        deadMenDAO.delete(deadMen);
    }

    @Override
    public DeadMen updateNumberByDistrict(String district, int newNumber) {
        DeadMen updatedRecord = deadMenDAO.getByDistrict(district);
        updatedRecord.setNumber(newNumber);

        deadMenDAO.update(updatedRecord);
        return updatedRecord;
    }

    @Override
    public DeadMen updateDistrictName(DeadMen deadMen, String district) {
        DeadMen updatedRecord = deadMen;
        updatedRecord.setDistrict(district);

        deadMenDAO.update(updatedRecord);
        return updatedRecord;
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
    public DeadMen getByDistrict(String district) {
        return deadMenDAO.getByDistrict(district);
    }

    @Override
    public DeadMen getById(int id) {
        return deadMenDAO.getById(id);
    }

    @Override
    public List<Object[]> getSimpleResultByDevRegn(String devReg) {
        return deadMenDAO.getSimpleResultByDevRegn(devReg);
    }
}
