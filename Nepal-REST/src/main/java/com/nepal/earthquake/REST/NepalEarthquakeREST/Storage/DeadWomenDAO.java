package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadWomen;

import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
public interface DeadWomenDAO {

    void delete(DeadWomen deadWomen);

    DeadWomen add(DeadWomen deadWomen);

    DeadWomen update(DeadWomen deadWomen);

    List<DeadWomen> getAll();

    List<DeadWomen> getByGeoRegion(String geoRegion);

    List<DeadWomen> getbyDevReg(String devReg);

    DeadWomen getByDistrict(String district);

    DeadWomen getById(int id);

    List<Object[]> getSimpleResultByDevRegn(String devReg);
}
