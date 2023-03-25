package com.kursach.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pribl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idTrip;

    public Pribl() {

    }

    public Long getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Long idTrip) {
        this.idTrip = idTrip;
    }

    public Long getId() {
        return id;
    }

    public String dohod;

    public Pribl(String dohod, String one_client, String wage_escort) {
        this.dohod = dohod;
        this.one_client = one_client;
        this.wage_escort = wage_escort;
    }

    public String getDohod() {
        return dohod;
    }

    public void setDohod(String dohod) {
        this.dohod = dohod;
    }

    public String getOne_client() {
        return one_client;
    }

    public void setOne_client(String one_client) {
        this.one_client = one_client;
    }

    public String getWage_escort() {
        return wage_escort;
    }

    public void setWage_escort(String wage_escort) {
        this.wage_escort = wage_escort;
    }

    public String one_client;
    public String wage_escort;
}
