package com.nepal.earthquake.REST.NepalEarthquakeREST.Models;
import javax.persistence.*;

/**
 * Created by Robert on 5/30/2017.
 */
@Entity
@Table(name = "`houses_destroyed`")
public class HousesDestroyed {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "`ID`")
    private int id;

    @Column(length = 50, name = "`district`")
    private String district;

    @Column(length = 50, name = "`development_region`")
    private String developmentRegion;

    @Column(length = 50, name = "`zone`")
    private String zone;

    @Column(length = 50, name = "`geographical_region")
    private String geographicalRegion;

    @Column(name = "`number`")
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDevelopmentRegion() {
        return developmentRegion;
    }

    public void setDevelopmentRegion(String developmentRegion) {
        this.developmentRegion = developmentRegion;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getGeographicalRegion() {
        return geographicalRegion;
    }

    public void setGeographicalRegion(String geographicalRegion) {
        this.geographicalRegion = geographicalRegion;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
