package com.kursach.models;

import javax.persistence.*;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user;
    @Column(length = 5000)
    private String text;
    private String date;

    public Reviews() {

    }

    public Reviews(String user, String text, String date) {
        this.user = user;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
