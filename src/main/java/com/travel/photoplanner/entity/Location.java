package com.travel.photoplanner.entity;

import javax.persistence.*;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Coordinates")
    private String coordinates;

    @Column(name = "Priority")
    private int priority;

    @Column(name = "Picture")
    private String picture;

    public Location(){
    }

    public Location(String name, String description, String coordinates, int priority, String picture) {
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
        this.priority = priority;
        this.picture = picture;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        builder.append(", ");
        builder.append(this.description);
        builder.append(", ");
        builder.append(this.coordinates);
        builder.append(", ");
        builder.append(this.priority);
        builder.append(", ");
        builder.append(this.picture);
        return builder.toString();
    }
}
