package com.mycompany.carpool.strategy;

import com.mycompany.carpool.models.Trip;

public interface PricingStrategy {

    public double getTripPrice(Trip currTrip);

}
