package com.nepal.earthquake.REST.NepalEarthquakeREST.Services.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Aftershocks;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.AftershocksService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.AftershocksDAO;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
@Service
public class AftershocksServiceImpl implements AftershocksService {

    @Autowired
    private AftershocksDAO aftershocksDAO;

    @Override
    public void updateDistrictMagnitude(String districtName, int newMagnitude) {

    }

    @Override
    public void deleteDistrictRecord(String districtName) {
        List<Aftershocks> aftershocks = aftershocksDAO.getByDistrict(districtName);

        for(Aftershocks a : aftershocks)
            aftershocksDAO.deleteDistrictRecord(a);

    }

    @Override
    public Aftershocks addNewRecord(Aftershocks newRecord) {
        aftershocksDAO.addNewRecord(newRecord);
        return newRecord;
    }

    @Override
    public List<Aftershocks> getAll() {
        return aftershocksDAO.getAll();
    }

    @Override
    public List<Aftershocks> getTop3ByMagnitude() {
        return aftershocksDAO.getTop3ByMagnitude();
    }

    @Override
    public List<Aftershocks> getLast3ByMagnitude() {
        return aftershocksDAO.getLast3ByMagnitude();
    }

    @Override
    public List<Object[]> getDetailedInformation() {
        return aftershocksDAO.getDetailedInformation();
    }
}
