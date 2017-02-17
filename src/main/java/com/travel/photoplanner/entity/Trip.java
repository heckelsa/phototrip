package com.travel.photoplanner.entity;

import com.travel.photoplanner.helper.Constants;
import com.travel.photoplanner.helper.DateHelper;

import javax.persistence.*;
import java.text.ParseException;
import java.util.*;

@Entity
@Table
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Country")
    private String country;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "DayTrip")
    private List<Day> dayList;


    public Trip() {
    }

    public Trip(String country, Date startDate, Date endDate) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Trip(String country, Date startDate, Date endDate, List<Day> dayList) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayList = dayList;
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

    public List<Day> getDayList() {
        return dayList;
    }

    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
    }


    /**********************
     * METHODS
     *********************/


    public String getFormattedStartDate() throws ParseException {
        String formattedDate = DateHelper.getFormattedDate(this.startDate, Constants.DATE_FORMAT_RENDER);
        return formattedDate;
    }

    public String getFormattedEndDate() throws ParseException {
        String formattedDate = DateHelper.getFormattedDate(this.endDate, Constants.DATE_FORMAT_RENDER);
        return formattedDate;
    }


    /****************************
    * TO STRING / HASH / EQUALS
    ****************************/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (id != trip.id) return false;
        if (!country.equals(trip.country)) return false;
        if (!startDate.equals(trip.startDate)) return false;
        if (!endDate.equals(trip.endDate)) return false;
        return dayList != null ? dayList.equals(trip.dayList) : trip.dayList == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + country.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + (dayList != null ? dayList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trip{" +
                       "id=" + id +
                       ", country='" + country + '\'' +
                       ", startDate=" + startDate +
                       ", endDate=" + endDate +
                       ", dayList=" + dayList +
                       '}';
    }
}

