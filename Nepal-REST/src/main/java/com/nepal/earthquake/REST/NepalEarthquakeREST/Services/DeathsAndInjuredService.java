package com.nepal.earthquake.REST.NepalEarthquakeREST.Services;


import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeathsAndInjured;

import java.util.List;

/**
 * Created by Robert on 5/14/2017.
 */
public interface DeathsAndInjuredService {


    List<DeathsAndInjured> getAll();

    void removeById(int id);

    void updateNumberOfDeaths(String districtName, int newNumberOfDeaths);

    void updateNumberOfInjuries(String districtName, int newNumberOfInjuries);

    DeathsAndInjured add(DeathsAndInjured deathsAndInjured);

    List<DeathsAndInjured> getTop10NumberOfDeaths();

    List<DeathsAndInjured> getLast10NumberOfDeaths();

    List<DeathsAndInjured> getTop10NumberOfInjuries();

    List<DeathsAndInjured> getLast10NumberOfInjuries();



}
