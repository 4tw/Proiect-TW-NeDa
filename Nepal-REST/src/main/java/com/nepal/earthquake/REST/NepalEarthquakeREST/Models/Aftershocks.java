package com.nepal.earthquake.REST.NepalEarthquakeREST.Models;

import javax.persistence.*;

/**
 * Created by Robert on 5/20/2017.
 */
@Entity
@Table(name = "`aftershocks`")
public class Aftershocks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`ID`")
    private int ID;

    @Column(length = 50, name = "`District`")
    private String district;

    //TODO transform to date
    @Column(length = 50, name = "`Date`")
    private String date;

    @Column(length = 50, name = "`Hour`")
    private String hour;

    @Column(name = "`Severity`")
    private Float severity;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Float getSeverity() {
        return severity;
    }

    public void setSeverity(Float severity) {
        this.severity = severity;
    }

}
