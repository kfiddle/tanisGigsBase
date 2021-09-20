package com.example.demo.models;


import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClockTime {

    @Id
    @GeneratedValue
    private Long id;

    private int hour;
    private int minute;

    public String toString() {
        return hour + ":" + minute;
    }

    public ClockTime() {}

    public ClockTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Long getId() {
        return id;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
