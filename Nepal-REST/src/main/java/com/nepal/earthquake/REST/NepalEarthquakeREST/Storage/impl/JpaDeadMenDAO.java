package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadMen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadWomen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadMenDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
@Repository
public class JpaDeadMenDAO implements DeadMenDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void delete(DeadMen deadMen) {
        entityManager.remove(deadMen);
    }

    @Transactional
    @Override
    public DeadMen add(DeadMen deadMen) {
        entityManager.persist(deadMen);
        return deadMen;
    }

    @Transactional
    @Override
    public DeadMen update(DeadMen deadMen) {
        entityManager.merge(deadMen);
        return deadMen;
    }

    @Override
    public List<DeadMen> getAll() {
        TypedQuery<DeadMen> query = entityManager.createQuery("select d from DeadMen d", DeadMen.class);

        return query.getResultList();
    }

    @Override
    public List<DeadMen> getByGeoRegion(String geoRegion) {
        TypedQuery<DeadMen> query = entityManager.createQuery("select d from DeadMen d " +
                "where geographicalRegion like :geoRegion", DeadMen.class)
                .setParameter("geoRegion", geoRegion);

        return query.getResultList();
    }

    @Override
    public List<DeadMen> getbyDevReg(String devReg) {
        TypedQuery<DeadMen> query = entityManager.createQuery("select d from DeadMen d " +
                "where developmentRegion like :devReg", DeadMen.class)
                .setParameter("devReg", devReg);

        return query.getResultList();
    }

    @Override
    public DeadMen getByDistrict(String district) {
        TypedQuery<DeadMen> query = entityManager.createQuery("select d from DeadMen d " +
                "where district like :district", DeadMen.class)
                .setParameter("district", district);

        return query.getSingleResult();
    }

    @Override
    public DeadMen getById(int id) {
        TypedQuery<DeadMen> query = entityManager.createQuery("select d from DeadMen d " +
                "where d.id = :id", DeadMen.class)
                .setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<Object[]> getSimpleResultByDevRegn(String devReg) {
        TypedQuery<Object[]> query = entityManager.createQuery("select distinct dm.district, ( 0 - dm.number), dw.number " +
                "from DeadMen dm, DeadWomen dw where dm.district = dw.district and " +
                "dm.developmentRegion like :devReg", Object[].class)
                .setParameter("devReg", devReg);

        return query.getResultList();
    }
}
