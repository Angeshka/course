package com.kursach.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Costs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Long idTrip) {
        this.idTrip = idTrip;
    }

    public Costs(Long idTrip) {
        this.idTrip = idTrip;
    }

    private Long idTrip;

    public Costs() {

    }

    public Long getId() {
        return id;
    }

    public String one_client;
    public String duration;

    public String getOne_client() {
        return one_client;
    }

    public void setOne_client(String one_client) {
        this.one_client = one_client;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getEscort() {
        return escort;
    }

    public void setEscort(String escort) {
        this.escort = escort;
    }

    public String getWage_escort() {
        return wage_escort;
    }

    public void setWage_escort(String wage_escort) {
        this.wage_escort = wage_escort;
    }

    public String transport;

    public Costs(String one_client, String duration, String transport, String hotel, String escort, String wage_escort) {
        this.one_client = one_client;
        this.duration = duration;
        this.transport = transport;
        this.hotel = hotel;
        this.escort = escort;
        this.wage_escort = wage_escort;
    }

    public String hotel;
    public String escort;
    public String wage_escort;
}
