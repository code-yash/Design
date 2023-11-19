package com.mycompany.carpool.strategy;

import com.mycompany.carpool.models.Trip;

public class DefaultPrice implements PricingStrategy {

    private double price;

    @Override
    public double getTripPrice(Trip currTrip) {
//        System.out.println("trip details: " + currTrip.getRider().getRiderName() + " " + currTrip.getDriver().getDriverName());
        if (currTrip.getBookedSeats() == 1) {
            price = (currTrip.getEndLoc().getxCord() - currTrip.getStartLoc().getxCord()) * 10;
        } else {
            price = (currTrip.getEndLoc().getxCord() - currTrip.getStartLoc().getxCord()) * currTrip.getBookedSeats() * 0.75 * 10;
        }
        return price;
    }

}
