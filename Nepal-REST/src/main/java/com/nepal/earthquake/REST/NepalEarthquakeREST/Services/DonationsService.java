package com.nepal.earthquake.REST.NepalEarthquakeREST.Services;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Donations;

import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
public interface DonationsService {

    void addDonations(Donations donations);

    void removeDonationsByDonor(String donor);

    void removeDonationsByFundation(String fundation);

    List<Donations> getAllDonations();

    List<Object[]> getDonationsByFundation(String fundation, int limit);

    List<Donations> getDetailedDonationsByFundation(String fundation, int limit);

    List<Donations> getTopDonations(int top);

    List<Donations> getLastDonations(int last);

    List<Donations> getDonationsByDonor(String donorName);
}
