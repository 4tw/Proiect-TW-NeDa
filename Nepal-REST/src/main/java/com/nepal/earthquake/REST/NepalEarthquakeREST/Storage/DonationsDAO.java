package com.nepal.earthquake.REST.NepalEarthquakeREST.Storage;

import com.nepal.earthquake.REST.NepalEarthquakeREST.Models.Donations;

import java.util.List;

/**
 * Created by Robert on 5/20/2017.
 */
public interface DonationsDAO {


    void add(Donations donations);

    void remove(Donations donation);


    List<Donations> getAllDonations();

    List<Object[]> getDonationsSumByFundation();

    List<Object[]> getDonationsByFundation(String fundation, int limit);

    List<Donations> getDetailedDonationsByFundation(String fundation , int limit);

    List<Donations> getTopDonations(int top);

    List<Donations> getLastDonations(int last);

    List<Donations> getDonationsByDonor(String donor);


}
