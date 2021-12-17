package com.diplproj.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "culture")
public class Culture {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "culture_name")
    private String cultureName;

    @OneToMany(mappedBy = "culture")
    private List<MicroclimateValue> microclimateValues;

    @OneToMany(mappedBy = "culture")
    private List<CulturePrice> culturePrices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(String cultureName) {
        this.cultureName = cultureName;
    }

    public List<MicroclimateValue> getMicroclimateValues() {
        return microclimateValues;
    }

    public void setMicroclimateValues(List<MicroclimateValue> microclimateValues) {
        this.microclimateValues = microclimateValues;
    }

    public List<CulturePrice> getCulturePrices() {
        return culturePrices;
    }

    public void setCulturePrices(List<CulturePrice> culturePrices) {
        this.culturePrices = culturePrices;
    }

}
