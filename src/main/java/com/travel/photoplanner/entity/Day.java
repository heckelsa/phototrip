package com.travel.photoplanner.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Day {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Date")
    private Date date;

    @OneToMany
    @JoinColumn(name = "Locations")
    private Set<Location> locationSet;

    public Day(){

    }

    public Day(Date date, Set<Location> locationSet) {
        this.date = date;
        this.locationSet = locationSet;
    }

    /**********************
     * GETTER AND SETTERS
     *********************/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Location> getLocationSet() {
        return locationSet;
    }

    public void setLocationSet(Set<Location> locationSet) {
        this.locationSet = locationSet;
    }

    @Override
    public String toString() {
        return "Day{" +
                       "id=" + id +
                       ", date=" + date +
                       ", locationSet=" + locationSet +
                       '}';
    }
}

