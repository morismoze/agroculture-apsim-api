package com.diplproj.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "location_name")
    private String locationName;

    @OneToMany(mappedBy = "yieldLocation")
    private List<CropYield> cropYields;

    @OneToMany(mappedBy = "microclimateLocation")
    private List<MicroclimateValue> microclimateValues;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @JsonManagedReference
    public List<CropYield> getCropYields() {
        return cropYields;
    }

    public void setCropYields(List<CropYield> cropYields) {
        this.cropYields = cropYields;
    }

    public List<MicroclimateValue> getMicroclimateValues() {
        return microclimateValues;
    }

    public void setMicroclimateValues(List<MicroclimateValue> microclimateValues) {
        this.microclimateValues = microclimateValues;
    }

}
