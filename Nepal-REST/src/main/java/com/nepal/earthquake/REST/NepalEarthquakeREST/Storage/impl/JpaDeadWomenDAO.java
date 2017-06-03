package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadWomen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadWomenDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TableGenerator;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
public class JpaDeadWomenDAO implements DeadWomenDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void delete(DeadWomen deadWomen) {
        entityManager.remove(deadWomen);
    }

    @Transactional
    @Override
    public DeadWomen add(DeadWomen deadWomen) {
        entityManager.persist(deadWomen);
        return deadWomen;
    }

    @Transactional
    @Override
    public DeadWomen update(DeadWomen deadWomen) {
        entityManager.merge(deadWomen);
        return deadWomen;
    }

    @Override
    public List<DeadWomen> getAll() {
        TypedQuery<DeadWomen> query = entityManager.createQuery("select d from DeadWomen d", DeadWomen.class);

        return query.getResultList();
    }

    @Override
    public List<DeadWomen> getByGeoRegion(String geoRegion) {
        TypedQuery<DeadWomen> query = entityManager.createQuery("select d from DeadWomen d where " +
                "geographicalRegion like :geoRegion", DeadWomen.class)
                .setParameter("geoRegion", geoRegion);

        return query.getResultList();
    }

    @Override
    public List<DeadWomen> getbyDevReg(String devReg) {
        TypedQuery<DeadWomen> query = entityManager.createQuery("select d from DeadWomen d where " +
                "developmentRegion like :devReg", DeadWomen.class)
                .setParameter("devReg",devReg);

        return query.getResultList();
    }

    @Override
    public List<DeadWomen> getByDistrict(String district) {
        TypedQuery<DeadWomen> query = entityManager.createQuery("select d from DeadWomen d where " +
                "district like :district", DeadWomen.class)
                .setParameter("district",district);

        return query.getResultList();
    }

    @Override
    public DeadWomen getById(int id) {
        TypedQuery<DeadWomen> query = entityManager.createQuery("select d from DeadWomen d where " +
                "id = :id", DeadWomen.class)
                .setParameter("id",id);

        return query.getSingleResult();
    }

    @Override
    public List<Object[]> getSimpleResultByDevRegn(String devReg) {
        return null;
    }
}
