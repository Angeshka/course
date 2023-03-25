package com.kursach.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 @Entity
 public class Docs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     public Docs() {

     }
     public Long getIdTrip() {
         return idTrip;
     }

     public void setIdTrip(Long idTrip) {
         this.idTrip = idTrip;
     }

     public Docs(Long idTrip) {
         this.idTrip = idTrip;
     }

     private Long idTrip;

     public String getPassport() {
         return passport;
     }

     public Docs(String passport, String tickets, String insurance) {
         this.passport = passport;
         this.tickets = tickets;
         this.insurance = insurance;
     }

     public void setPassport(String passport) {
         this.passport = passport;
     }

     public String getTickets() {
         return tickets;
     }

     public void setTickets(String tickets) {
         this.tickets = tickets;
     }

     public String getInsurance() {
         return insurance;
     }

     public void setInsurance(String insurance) {
         this.insurance = insurance;
     }

     private String passport;
     private String tickets;
     private String insurance;
}
