package com.diplproj.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "crop_yield")
public class CropYield {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private Double value;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location yieldLocation;

    @ManyToOne
    @JoinColumn(name = "id_culture")
    private Culture culture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonBackReference
    public Location getYieldLocation() {
        return yieldLocation;
    }

    public void setYieldLocation(Location yieldLocation) {
        this.yieldLocation = yieldLocation;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }
}
