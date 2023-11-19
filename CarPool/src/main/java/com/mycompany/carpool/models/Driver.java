package com.mycompany.carpool.models;

import java.util.UUID;

public class Driver {

    private String driverId;
    private String driverName;
    private int seatCount;
    private boolean driverAvailability;

    public Driver(String driverName, int seatCount, boolean driverAvailability) {
        this.driverId = UUID.randomUUID().toString();
        this.driverName = driverName;
        this.seatCount = seatCount;
        this.driverAvailability = false;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public boolean isDriverAvailability() {
        return driverAvailability;
    }

    public void setDriverAvailability(boolean driverAvailability) {
        this.driverAvailability = driverAvailability;
    }

    public String getDriverId() {
        return driverId;
    }

}
