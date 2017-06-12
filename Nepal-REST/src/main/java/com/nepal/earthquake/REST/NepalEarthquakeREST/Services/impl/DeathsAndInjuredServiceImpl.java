package com.nepal.earthquake.REST.NepalEarthquakeREST.Services.impl;


import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeathsAndInjured;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DeathsAndInjuredService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeathsInjuredDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Robert on 5/14/2017.
 */

@Service
public class DeathsAndInjuredServiceImpl implements DeathsAndInjuredService {

    @Autowired
    private DeathsInjuredDAO casualtyCount;

    @Override
    public List<DeathsAndInjured> getAll() {
        return casualtyCount.getAll();
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public void updateNumberOfDeaths(String districtName, int newNumberOfDeaths) {

    }

    @Override
    public void updateNumberOfInjuries(String districtName, int newNumberOfInjuries) {

    }

    @Override
    public DeathsAndInjured add(DeathsAndInjured deathsAndInjured) {
        return null;
    }

    @Override
    public List<DeathsAndInjured> getTop10NumberOfDeaths() {
        return casualtyCount.getTop10NumberOfDeaths();
    }

    @Override
    public List<DeathsAndInjured> getLast10NumberOfDeaths() {
        return casualtyCount.getLast10NumberOfDeaths();
    }

    @Override
    public List<DeathsAndInjured> getTop10NumberOfInjuries() {
        return casualtyCount.getTop10NumberOfInjuries();
    }

    @Override
    public List<DeathsAndInjured> getLast10NumberOfInjuries() {
        return casualtyCount.getLast10NumberOfInjuries();
    }

}
