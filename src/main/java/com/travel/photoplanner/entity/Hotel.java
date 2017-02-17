package com.travel.photoplanner.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Coordinates")
    private String coordinates;

    @Column(name = "Breakfast")
    private boolean breakfast;

    @Column(name = "Kitchen")
    private boolean kitchen;

    @Column(name = "Price")
    private int price;

    @Column(name = "PriceBreakfast")
    private int priceBreakfast;

    @Column(name = "CheckinStart")
    private Date checkinStart;

    @Column(name = "CheckinEnd")
    private Date checkinEnd;

    @Column(name = "CheckoutStart")
    private Date checkoutStart;

    @Column(name = "CheckoutEnd")
    private Date checkoutEnd;

    @Column(name = "stayStart")
    private Date stayStart;

    @Column(name = "stayEnd")
    private Date stayEnd;

    @Column(name = "Images")
    private String images;

    public Hotel(){

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isKitchen() {
        return kitchen;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceBreakfast() {
        return priceBreakfast;
    }

    public void setPriceBreakfast(int priceBreakfast) {
        this.priceBreakfast = priceBreakfast;
    }

    public Date getCheckinStart() {
        return checkinStart;
    }

    public void setCheckinStart(Date checkinStart) {
        this.checkinStart = checkinStart;
    }

    public Date getCheckinEnd() {
        return checkinEnd;
    }

    public void setCheckinEnd(Date checkinEnd) {
        this.checkinEnd = checkinEnd;
    }

    public Date getCheckoutStart() {
        return checkoutStart;
    }

    public void setCheckoutStart(Date checkoutStart) {
        this.checkoutStart = checkoutStart;
    }

    public Date getCheckoutEnd() {
        return checkoutEnd;
    }

    public void setCheckoutEnd(Date checkoutEnd) {
        this.checkoutEnd = checkoutEnd;
    }

    public Date getStayStart() {
        return stayStart;
    }

    public void setStayStart(Date stayStart) {
        this.stayStart = stayStart;
    }

    public Date getStayEnd() {
        return stayEnd;
    }

    public void setStayEnd(Date stayEnd) {
        this.stayEnd = stayEnd;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    /**********************
     * METHODS
     *********************/


    /****************************
     * TO STRING / HASH / EQUALS
     ****************************/

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", breakfast=" + breakfast +
                ", kitchen=" + kitchen +
                ", price=" + price +
                ", priceBreakfast=" + priceBreakfast +
                ", checkinStart=" + checkinStart +
                ", checkinEnd=" + checkinEnd +
                ", checkoutStart=" + checkoutStart +
                ", checkoutEnd=" + checkoutEnd +
                ", stayStart=" + stayStart +
                ", stayEnd=" + stayEnd +
                ", images='" + images + '\'' +
                '}';
    }
}
