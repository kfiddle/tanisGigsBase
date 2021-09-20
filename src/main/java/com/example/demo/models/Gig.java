package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Gig implements Comparable<Gig>{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Collection<Player> players;

    private LocalDate date;
    private String ensembleType;
    private String location;
    private String notes;
    private int totalFeeInCents;

    public Gig() {}

    public Gig(LocalDate date, String ensembleType, String location, String notes, int totalFeeInCents) {
        this.date = date;
        this.ensembleType = ensembleType;
        this.location = location;
        this.notes = notes;
        this.totalFeeInCents = totalFeeInCents;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEnsembleType(String ensembleType) {
        this.ensembleType = ensembleType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setTotalFeeInCents(int totalFeeInCents) {
        this.totalFeeInCents = totalFeeInCents;
    }

    public Long getId() {
        return id;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEnsembleType() {
        return ensembleType;
    }

    public String getLocation() {
        return location;
    }

    public String getNotes() {
        return notes;
    }

    public int getTotalFeeInCents() {
        return totalFeeInCents;
    }

    @Override
    public int compareTo(Gig otherGig) {
        return date.compareTo(otherGig.getDate());
    }
}
