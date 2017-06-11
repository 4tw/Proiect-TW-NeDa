package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Aftershocks;
import org.aspectj.lang.annotation.After;

import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
public interface AftershocksDAO {
    void update(Aftershocks aftershocks);

    void deleteDistrictRecord(Aftershocks aftershocks);

    Aftershocks addNewRecord(Aftershocks newRecord);

    List<Aftershocks> getAll();

    List<Object[]> getDetailedInformation();

    List<Aftershocks> getTop3ByMagnitude();

    List<Aftershocks> getLast3ByMagnitude();

    Aftershocks getById(int id);

    List<Aftershocks> getByDistrict(String district);

}
