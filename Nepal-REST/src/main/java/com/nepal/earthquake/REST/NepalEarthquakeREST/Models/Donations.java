package com.nepal.earthquake.REST.NepalEarthquakeREST.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Robert on 5/20/2017.
 */
@Entity
@Table(name = "`donations`")
public class Donations {

    @Id
    @Column(unique = true, nullable = false, name = "`ID`")
    private int ID;

    //TODO transform to date
    @Column( name = "`Date`")
    private String date;

    @Column(length = 100, nullable = false, name = "`Donation_type`")
    private String donationType;

    @Column( length = 50, name = "`Donor`")
    private String donor;

    @Column( name = "`Net_donation`")
    private Double netDonation;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public Double getNetDonation() {
        return netDonation;
    }

    public void setNetDonation(Double netDonation) {
        this.netDonation = netDonation;
    }
}
