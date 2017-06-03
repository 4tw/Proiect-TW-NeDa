package com.nepal.earthquake.REST.NepalEarthquakeREST.Models;

import javax.persistence.*;

/**
 * Created by Robert on 5/30/2017.
 */
@Entity
@Table(name = "`dead_female`")
public class DeadWomen {
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

    @Column(length = 50, name = "`geographical_region`")
    private String geographicalRegion;

    @Column(name = "`number`")
    private int number;
}
