package com.example.demo.models;


import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Gig implements Comparable<Gig> {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Collection<Player> players;

    private LocalDate date;
    private String location;

    @OneToOne
    private ClockTime startTime;

    @OneToOne
    private ClockTime endTime;

    private String ensembleType;
    private String client;
    private String notes;
    private int totalFeeInCents;



    public Gig() {
    }

    public Gig(LocalDate date, String ensembleType, String location, String client, String notes, int totalFeeInCents) {
        this.date = date;
        this.ensembleType = ensembleType;
        this.client = client;
        this.location = location;
        this.notes = notes;
        this.totalFeeInCents = totalFeeInCents;
    }

    public Gig(LocalDate date, String location, ClockTime startTime, ClockTime endTime, String ensembleType, String client, String notes, int totalFeeInCents) {
        this.date = date;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ensembleType = ensembleType;
        this.client = client;
        this.notes = notes;
        this.totalFeeInCents = totalFeeInCents;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setClient(String client) {
        this.client = client;
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

    public void setStartTime(ClockTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(ClockTime endTime) {
        this.endTime = endTime;
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

    public String getClient() {
        return client;
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

    public ClockTime getStartTime() {
        return startTime;
    }

    public ClockTime getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Gig otherGig) {
        return date.compareTo(otherGig.getDate());
    }


    public void setAllProps(Gig otherGig) {

        if (otherGig.getDate() != null) {
            date = otherGig.getDate();
        }
        if (otherGig.getLocation() != null) {
            location = otherGig.getLocation();
        }
        if (otherGig.getTotalFeeInCents() > 0) {
            totalFeeInCents = otherGig.getTotalFeeInCents();
        }
        if (otherGig.getStartTime() != null) {
            startTime = otherGig.getStartTime();
        }
        if (otherGig.getEndTime() != null) {
            endTime = otherGig.getEndTime();
        }
        if (otherGig.getEnsembleType() != null) {
            ensembleType = otherGig.getEnsembleType();
        }






    }


}
