package com.travel.photoplanner;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Trip {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Country")
    private String country;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    public Trip(String country, Date startDate, Date endDate) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /*********************
     * GETTER AND SETTERS
     ********************/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

