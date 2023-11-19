package com.mycompany.carpool.models;

import java.util.UUID;

public class Trip {

    String tripId;
    private Driver driver;
    private Rider rider;
    private double price;
    private int bookedSeats;
    private Location startLoc;
    private Location endLoc;

    public Trip() {
        this.tripId = UUID.randomUUID().toString();
        this.driver = null;
        this.rider = null;
        this.price = 0;
        this.bookedSeats = 0;
        this.startLoc = null;
        this.endLoc = null;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int seatsAvailable) {
        this.bookedSeats = seatsAvailable;
    }

    public Location getStartLoc() {
        return startLoc;
    }

    public void setStartLoc(Location startLoc) {
        this.startLoc = startLoc;
    }

    public Location getEndLoc() {
        return endLoc;
    }

    public void setEndLoc(Location endLoc) {
        this.endLoc = endLoc;
    }

    public String getTripId() {
        return this.tripId;
    }
}
