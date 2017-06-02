package com.nepal.earthquake.REST.NepalEarthquakeREST.Models;

import javax.persistence.*;

/**
 * Created by Robert on 5/14/2017.
 */
@Entity
@Table(name="deaths_and_Injured")
public class DeathsAndInjured {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "ID")
    private int id;

    @Column(length = 50, nullable = false, name = "District_name")
    private String districtName;

    @Column(nullable = false, name = "Number_of_Deaths")
    private int deathsCount;

    @Column(nullable = false, name = "Number_of_Injured")
    private int injuredCount;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getDeathsCount() {
        return deathsCount;
    }

    public void setDeathsCount(int deathsCount) {
        this.deathsCount = deathsCount;
    }

    public int getInjuredCount() {

        return injuredCount;
    }

    public void setInjuredCount(int injuredCount) {
        this.injuredCount = injuredCount;
    }
}
