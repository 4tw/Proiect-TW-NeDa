package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadMen;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */

public interface DeadMenDAO {

    void delete(DeadMen deadMen);

    DeadMen add(DeadMen deadMen);

    DeadMen update(DeadMen deadMen);

    List<DeadMen> getAll();

    List<DeadMen> getByGeoRegion(String geoRegion);

    List<DeadMen> getbyDevReg(String devReg);

    List<DeadMen> getByDistrict(String district);

    List<DeadMen> getById(int id);

    List<Object[]> getSimpleResultByDevRegn(String devReg);

}
