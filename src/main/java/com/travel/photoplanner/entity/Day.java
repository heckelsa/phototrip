package com.travel.photoplanner.entity;

import com.travel.photoplanner.helper.DateHelper;

import javax.persistence.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "Locations")
    private List<Location> locationList;

    public Day(){

    }

    public Day(Date date){
        this.date = date;
    }

    public Day(Date date, List<Location> locationList) {
        this.date = date;
        this.locationList = locationList;
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

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }


    /**********************
     * METHODS
     *********************/


    public String getFormattedDate() throws ParseException {
        String formattedDate = DateHelper.getFormattedDate(this.date);
        return formattedDate;
    }

    public Location getLocationById(int locationId){

        Location location;

        for(Iterator<Location> iterator = this.locationList.iterator(); iterator.hasNext(); ){
            location = iterator.next();
            if(locationId == location.getId()){
                return location;
            }
        }

        return null;
    }


    /****************************
     * TO STRING / HASH / EQUALS
     ****************************/


    @Override
    public String toString() {
        return "Day{" +
                       "id=" + id +
                       ", date=" + date +
                       ", locationList=" + locationList +
                       '}';
    }


}

