package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Donations;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DonationsDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
@Repository
public class JpaDonationsDAO implements DonationsDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void add(Donations donations) {
        entityManager.persist(donations);
    }

    @Transactional
    @Override
    public void remove(Donations donation) {
        entityManager.remove(donation);
    }


    @Override
    public List<Donations> getAllDonations() {
        TypedQuery<Donations> query = entityManager.createQuery("select d from Donations d", Donations.class);
        return query.getResultList();
    }

    @Override
    public List<Donations> getDonationsSumByFundation() {
        Query query = entityManager.createQuery("SELECT id, donation_type, sum(net_donation) FROM Donations group by donation_type", Donations.class);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getDonationsByFundation(String fundation, int limit) {
        TypedQuery<Object[]> query = entityManager.createQuery("select d.donationType, d.donor, d.netDonation " +
                "  from Donations d where Donation_Type like :fundation " +
                "order by Net_donation desc", Object[].class)
                .setParameter("fundation", fundation);
        if(limit > 0)
            query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public List<Donations> getDetailedDonationsByFundation(String fundation, int limit) {
        TypedQuery<Donations> query = entityManager.createQuery("select d " +
                "  from Donations d where Donation_Type like :fundation " +
                "order by Net_donation desc", Donations.class)
                .setParameter("fundation", fundation);
        if(limit > 0)
            query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public List<Donations> getTopDonations(int top) {

        TypedQuery<Donations> query = entityManager.createQuery(
                "select d from Donations d order by Net_donation desc", Donations.class);

        query.setMaxResults(top);
        return query.getResultList();
    }

    @Override
    public List<Donations> getLastDonations(int last) {
        TypedQuery<Donations> query = entityManager.createQuery(
                "select d from Donations d order by Net_donation asc", Donations.class);
        query.setMaxResults(last);
        return query.getResultList();
    }

    @Override
    public List<Donations> getDonationsByDonor(String donor) {
        donor = "%" + donor + "%";
        TypedQuery<Donations> query = entityManager.createQuery(
                "select d from Donations d where Donor like :donorName",Donations.class)
                .setParameter("donorName", donor);

        return query.getResultList();
    }
}
