package com.mycompany.carpool.strategy;

import com.mycompany.carpool.models.Driver;
import com.mycompany.carpool.models.Trip;
import java.util.List;

public interface DriverMatchingStrategy {

    public Driver getMatchedDriver(List<Driver> availableDrivers, Trip trip);
}
