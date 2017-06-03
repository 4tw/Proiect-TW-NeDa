package com.nepal.earthquake.REST.NepalEarthquakeREST.Services.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadWomen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DeadWomenService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadMenDAO;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadWomenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
@Service
public class DeadWomenServiceImpl implements DeadWomenService {

    @Autowired
    private DeadWomenDAO deadWomenDAO;


    @Override
    public List<DeadWomen> getAll() {
        return deadWomenDAO.getAll();
    }

    @Override
    public DeadWomen add(DeadWomen deadWomen) {
        deadWomenDAO.add(deadWomen);

        return deadWomen;
    }

    @Override
    public void removeByDistrict(String district) {
        DeadWomen deadWomen = deadWomenDAO.getByDistrict(district);

        deadWomenDAO.delete(deadWomen);



    }

    @Override
    public DeadWomen updateNumberByDistrict(String district, int newNumber) {
        DeadWomen deadWomen = deadWomenDAO.getByDistrict(district);

        deadWomen.setNumber(newNumber);

        deadWomenDAO.update(deadWomen);

        return deadWomen;
    }

    @Override
    public DeadWomen updateDistrictName(String oldDistrictName, String newDistrictName) {
        DeadWomen deadWomen = deadWomenDAO.getByDistrict(oldDistrictName);

        deadWomen.setDistrict(newDistrictName);

        deadWomenDAO.update(deadWomen);

        return deadWomen;
    }

    @Override
    public List<DeadWomen> getByGeoRegion(String geoRegion) {
        return deadWomenDAO.getByGeoRegion(geoRegion);
    }

    @Override
    public List<DeadWomen> getbyDevReg(String devReg) {
        return deadWomenDAO.getbyDevReg(devReg);
    }

    @Override
    public DeadWomen getByDistrict(String district) {
        return deadWomenDAO.getByDistrict(district);
    }

    @Override
    public DeadWomen getById(int id) {
        return deadWomenDAO.getById(id);
    }

    @Override
    public List<Object[]> getSimpleResultByDevRegn(String devReg) {
        return deadWomenDAO.getSimpleResultByDevRegn(devReg);
    }
}
