package com.diplproj.api.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "microclimate_value")
public class MicroclimateValue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "microclimate_value")
    private Double microclimateValue;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_culture")
    private Culture culture;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location microclimateLocation;

    @ManyToOne
    @JoinColumn(name = "id_microclimate")
    private MicroclimateName microclimateName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMicroclimateValue() {
        return microclimateValue;
    }

    public void setMicroclimateValue(Double microclimateValue) {
        this.microclimateValue = microclimateValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public Location getMicroclimateLocation() {
        return microclimateLocation;
    }

    public void setMicroclimateLocation(Location microclimateLocation) {
        this.microclimateLocation = microclimateLocation;
    }

    public MicroclimateName getMicroclimateName() {
        return microclimateName;
    }

    public void setMicroclimateName(MicroclimateName microclimateName) {
        this.microclimateName = microclimateName;
    }

}