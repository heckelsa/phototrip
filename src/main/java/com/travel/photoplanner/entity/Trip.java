package com.travel.photoplanner.entity;

import com.travel.photoplanner.helper.PhototripHelper;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "DayTrip")
    private Set<Day> daySet;


    public Trip(){
    }

    public Trip(String country, Date startDate, Date endDate) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Trip(String country, Date startDate, Date endDate, Set<Day> daySet) {
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daySet = daySet;
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

    public Set<Day> getDaySet() {
        return daySet;
    }

    public void setDaySet(Set<Day> daySet) {
        this.daySet = daySet;
    }

    public String getFormattedStartDate() throws ParseException {
        String formattedDate = PhototripHelper.getFormattedDate(startDate);
        return formattedDate;
    }

    public String getFormattedEndDate() throws ParseException {
        String formattedDate = PhototripHelper.getFormattedDate(endDate);
        return formattedDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (id != trip.id) return false;
        if (!country.equals(trip.country)) return false;
        if (!startDate.equals(trip.startDate)) return false;
        if (!endDate.equals(trip.endDate)) return false;
        return daySet != null ? daySet.equals(trip.daySet) : trip.daySet == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + country.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + (daySet != null ? daySet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trip{" +
                       "id=" + id +
                       ", country='" + country + '\'' +
                       ", startDate=" + startDate +
                       ", endDate=" + endDate +
                       ", daySet=" + daySet +
                       '}';
    }
}

