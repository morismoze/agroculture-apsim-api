package com.diplproj.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "microclimate_name")
public class MicroclimateName {

    @Id
    private Integer id;

    @Column(name = "microclimate_name")
    private String microclimateName;

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

}
