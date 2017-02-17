package com.travel.photoplanner.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Screenshot")
    private String screenshot;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "Locations")
    private List<Location> locationList;

    /**********************
     * GETTER AND SETTERS
     *********************/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
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


    /****************************
     * TO STRING / HASH / EQUALS
     ****************************/

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", screenshot='" + screenshot + '\'' +
                ", locationList=" + locationList +
                '}';
    }
}
