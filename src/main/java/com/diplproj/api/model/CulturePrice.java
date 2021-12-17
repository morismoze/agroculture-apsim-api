package com.diplproj.api.model;

import javax.persistence.*;

@Entity
@Table(name = "culture_price")
public class CulturePrice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Double price;

    @Column(name = "year")
    private Double year;

    @ManyToOne
    @JoinColumn(name = "id_culture")
    private Culture culture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getYear() {
        return year;
    }

    public void setYear(Double year) {
        this.year = year;
    }

    public Culture getCulturePrice() {
        return culture;
    }

    public void setCulturePrice(Culture culturePrice) {
        this.culture = culturePrice;
    }

}
