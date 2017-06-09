package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.HousesDestroyed;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.HousesDestroyedDAO;
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
public class JpaHousesDestroyedDAO implements HousesDestroyedDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void delete(HousesDestroyed housesDestroyed) {
            entityManager.remove(housesDestroyed);
    }

    @Transactional
    @Override
    public HousesDestroyed update(HousesDestroyed housesDestroyed) {
        entityManager.merge(housesDestroyed);
        return housesDestroyed;
    }

    @Transactional
    @Override
    public HousesDestroyed add(HousesDestroyed housesDestroyed) {
        entityManager.persist(housesDestroyed);
        return housesDestroyed;
    }

    @Override
    public List<HousesDestroyed> getAll() {
        TypedQuery<HousesDestroyed> query = entityManager.createQuery("SELECT h from HousesDestroyed h", HousesDestroyed.class);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getShortAll() {
        TypedQuery<Object[]> query = entityManager.createQuery("SELECT h.latitude, h.longitude, h.number " +
                        " from HousesDestroyed h ",
                Object[].class);

        return query.getResultList();
    }

    @Override
    public List<HousesDestroyed> getByGeoRegion(String geoReg) {
        geoReg = "%" + geoReg + "%";

        TypedQuery<HousesDestroyed> query = entityManager.createQuery("SELECT h from HousesDestroyed h " +
                        "where geographicalRegion like :geoReg",
                        HousesDestroyed.class)
                        .setParameter("geoReg", geoReg);

        return query.getResultList();
    }

    @Override
    public List<HousesDestroyed> getByDevReg(String devReg) {

        TypedQuery<HousesDestroyed> query = entityManager.createQuery("SELECT h from HousesDestroyed h " +
                        "where developmentRegion like :devReg",
                HousesDestroyed.class)
                .setParameter("devReg", devReg);

        return query.getResultList();
    }

    @Override
    public List<HousesDestroyed> getByDistrict(String district) {
        TypedQuery<HousesDestroyed> query = entityManager.createQuery("SELECT h from HousesDestroyed h " +
                        "where district like :district",
                HousesDestroyed.class)
                .setParameter("district", district);

        return query.getResultList();
    }

    @Override
    public List<Object[]> getSimpleResultByZone(String zone) {
        TypedQuery<Object[]> query = entityManager.createQuery("SELECT h.district, h.number from HousesDestroyed h " +
                        "where zone like :zone",
                Object[].class)
                .setParameter("zone", zone);

        return query.getResultList();
    }
}
