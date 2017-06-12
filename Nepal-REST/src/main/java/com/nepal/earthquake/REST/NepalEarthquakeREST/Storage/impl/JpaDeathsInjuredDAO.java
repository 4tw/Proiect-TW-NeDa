package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.DeathsAndInjured;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DeathsInjuredDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Robert on 5/14/2017.
 */
@Repository
public class JpaDeathsInjuredDAO implements DeathsInjuredDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public DeathsAndInjured add(DeathsAndInjured deathsAndInjured) {

        entityManager.persist(deathsAndInjured);
        return deathsAndInjured;
    }

    @Transactional
    @Override
    public void remove(DeathsAndInjured deathsAndInjured) {
        entityManager.remove(deathsAndInjured);
    }

    @Transactional
    @Override
    public void update(DeathsAndInjured deathsAndInjured) {
        entityManager.merge(deathsAndInjured);
    }



    @Override
    public List<DeathsAndInjured> getAll() {
        TypedQuery<DeathsAndInjured> query = entityManager.createQuery("select d from DeathsAndInjured d", DeathsAndInjured.class);
        return query.getResultList();
    }


    @Override
    public List<DeathsAndInjured> getTop10NumberOfDeaths() {
        TypedQuery<DeathsAndInjured> query = entityManager.createQuery("select d from DeathsAndInjured d order by Number_of_deaths desc",
                DeathsAndInjured.class);
        query.setMaxResults(10);

        return query.getResultList();
    }

    @Override
    public List<DeathsAndInjured> getLast10NumberOfDeaths() {
        TypedQuery<DeathsAndInjured> query = entityManager.createQuery("select d from DeathsAndInjured d order by Number_of_deaths asc",
                DeathsAndInjured.class);
        query.setMaxResults(10);

        return query.getResultList();
    }

    @Override
    public List<DeathsAndInjured> getTop10NumberOfInjuries() {
        TypedQuery<DeathsAndInjured> query = entityManager.createQuery("select d from DeathsAndInjured d order by Number_of_injured desc",
                DeathsAndInjured.class);
        query.setMaxResults(10);

        return query.getResultList();
    }

    @Override
    public List<DeathsAndInjured> getLast10NumberOfInjuries() {
        TypedQuery<DeathsAndInjured> query = entityManager.createQuery("select d from DeathsAndInjured d order by Number_of_injured asc",
                DeathsAndInjured.class);
        query.setMaxResults(10);

        return query.getResultList();
    }
}
