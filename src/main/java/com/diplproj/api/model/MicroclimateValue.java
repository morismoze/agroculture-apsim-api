package com.diplproj.api.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "microclimate_value")
public class MicroclimateValue {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_culture")
    private Integer idCulture;

    @Column(name = "id_microclimate")
    private Integer idMicroclimate;

    @Column(name = "id_location")
    private Integer idLocation;

    @Column(name = "microclimate_value")
    private Double microclimateValue;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCulture() {
        return idCulture;
    }

    public void setIdCulture(Integer idCulture) {
        this.idCulture = idCulture;
    }

    public Integer getIdMicroclimate() {
        return idMicroclimate;
    }

    public void setIdMicroclimate(Integer idMicroclimate) {
        this.idMicroclimate = idMicroclimate;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
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

}