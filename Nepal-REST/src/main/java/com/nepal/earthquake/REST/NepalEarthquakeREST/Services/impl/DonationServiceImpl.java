package com.nepal.earthquake.REST.NepalEarthquakeREST.Services.impl;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Donations;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Services.DonationsService;
import com.nepal.earthquake.REST.NepalEarthquakeREST.Storage.DonationsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
@Service
public class DonationServiceImpl implements DonationsService{
    @Autowired
    private DonationsDAO donationsDAO;

    @Override
    public void addDonations(Donations donations) {
        donationsDAO.add(donations);
    }

    @Override
    public void removeDonationsByDonor(String donor) {
        List<Donations> results = donationsDAO.getDonationsByDonor(donor);

        for(Donations row : results){
            donationsDAO.remove(row);
        }

    }

    @Override
    public void removeDonationsByFundation(String fundation) {
            List<Donations> donations = donationsDAO.getDetailedDonationsByFundation(fundation, 0);

            for(Donations d : donations)
                donationsDAO.remove(d);
    }

    @Override
    public List<Donations> getAllDonations() {
        return donationsDAO.getAllDonations();
    }

    @Override
    public List<Object[]> getDonationsByFundation(String fundation, int limit) {

        fundation = "%" + fundation + "%";
        return donationsDAO.getDonationsByFundation(fundation, limit);
    }

    @Override
    public List<Donations> getDetailedDonationsByFundation(String fundation, int limit) {
        return donationsDAO.getDetailedDonationsByFundation(fundation,limit);
    }

    @Override
    public List<Donations> getTopDonations(int top) {
        return donationsDAO.getTopDonations(top);
    }

    @Override
    public List<Donations> getLastDonations(int last) {
        return donationsDAO.getLastDonations(last);
    }

    @Override
    public List<Donations> getDonationsByDonor(String donorName) {
        return donationsDAO.getDonationsByDonor(donorName);
    }


}
