package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeathsAndInjured;

import java.util.List;

/**
 * Created by Robert on 5/14/2017.
 */
public interface DeathsInjuredDAO {

    void remove(DeathsAndInjured deathsAndInjured);

    void update(DeathsAndInjured deathsAndInjured);

    List<DeathsAndInjured> getAll();

    DeathsAndInjured add(DeathsAndInjured deathsAndInjured);

    List<DeathsAndInjured> getTop10NumberOfDeaths();

    List<DeathsAndInjured> getLast10NumberOfDeaths();

    List<DeathsAndInjured> getTop10NumberOfInjuries();

    List<DeathsAndInjured> getLast10NumberOfInjuries();

}
