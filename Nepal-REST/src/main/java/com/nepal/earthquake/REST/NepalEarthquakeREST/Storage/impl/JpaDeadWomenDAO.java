package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeadWomen;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeadWomenDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TableGenerator;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Robert on 5/30/2017.
 */
@Repository
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
                "d.district like :district", DeadWomen.class)
                .setParameter("district",district);

        return query.getResultList();
    }

    @Override
    public List<DeadWomen> getById(int id) {
        TypedQuery<DeadWomen> query = entityManager.createQuery("select d from DeadWomen d where " +
                "id = :id", DeadWomen.class)
                .setParameter("id",id);
        query.setMaxResults(1);

        return query.getResultList();
    }

    @Override
    public List<Object[]> getSimpleResultByDevRegn(String devReg) {
        devReg = "%" + devReg + "%";
        TypedQuery<Object[]> query = entityManager.createQuery("select d.district, d.number from DeadWomen d " +
                "where developmentRegion like :devReg", Object[].class)
                .setParameter("devReg", devReg);

        return query.getResultList();
    }
}
