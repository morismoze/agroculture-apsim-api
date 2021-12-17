package com.diplproj.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "microclimate_name")
public class MicroclimateName {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "microclimate_name")
    private String microclimateName;

    @OneToMany(mappedBy = "microclimateName")
    private List<MicroclimateValue> microclimateValues;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMicroclimateName() {
        return microclimateName;
    }

    public void setMicroclimateName(String microclimateName) {
        this.microclimateName = microclimateName;
    }

    public List<MicroclimateValue> getMicroclimateValues() {
        return microclimateValues;
    }

    public void setMicroclimateValues(List<MicroclimateValue> microclimateValues) {
        this.microclimateValues = microclimateValues;
    }
}
