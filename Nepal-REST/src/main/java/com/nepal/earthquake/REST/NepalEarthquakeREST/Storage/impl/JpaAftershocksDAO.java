package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Aftershocks;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.AftershocksDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
@Repository
public class JpaAftershocksDAO implements AftershocksDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void update(Aftershocks aftershocks) {
        entityManager.merge(aftershocks);

    }

    @Transactional
    @Override
    public void deleteDistrictRecord(Aftershocks aftershocks) {
        entityManager.remove(aftershocks);
    }

    @Transactional
    @Override
    public Aftershocks addNewRecord(Aftershocks newRecord) {
        entityManager.persist(newRecord);
        return newRecord;
    }

    @Override
    public List<Aftershocks> getAll() {
        TypedQuery<Aftershocks> query = entityManager.createQuery(
                "select a from Aftershocks a", Aftershocks.class);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getDetailedInformation() {
        TypedQuery<Object[]> query = entityManager.createQuery(
                "select h.latitude, h.longitude, a.district, a.severity, a.hour, a.date from " +
                        "Aftershocks a, HousesDestroyed h where a.district = h.district " +
                        "order by 6,5 asc", Object[].class);
        return query.getResultList();
    }

    @Override
    public List<Aftershocks> getTop3ByMagnitude() {
        TypedQuery<Aftershocks> query = entityManager.createQuery(
                "select a from Aftershocks a order by Severity desc", Aftershocks.class);
        query.setMaxResults(3);
        return query.getResultList();
    }

    @Override
    public List<Aftershocks> getLast3ByMagnitude() {
        TypedQuery<Aftershocks> query = entityManager.createQuery(
                "select a from Aftershocks a order by Severity asc", Aftershocks.class);
        query.setMaxResults(3);
        return query.getResultList();
    }

    @Override
    public Aftershocks getById(int id) {
        TypedQuery<Aftershocks> query = entityManager.createQuery(
                "select a from Aftershocks a where ID = :id",Aftershocks.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Aftershocks> getByDistrict(String district) {
        TypedQuery<Aftershocks> query = entityManager.createQuery(
                "select a from Aftershocks a where District like :district", Aftershocks.class)
                .setParameter("district", district);
        return query.getResultList();
    }
}
