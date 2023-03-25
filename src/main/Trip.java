package com.kursach.models;

import javax.persistence.*;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getCountry() {
        return country;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String country;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String poster;

    public Trip() {
    }

    public Trip(String country, String price, String quantity, String name) {
        this.country = country;
        this.price = price;
        this.quantity = quantity;
        this.name = name;

    }

    public String price;
    public String quantity;

    public Trip(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;


    public Long getId() {
        return id;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }






}
