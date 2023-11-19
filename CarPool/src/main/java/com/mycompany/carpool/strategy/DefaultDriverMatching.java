package com.mycompany.carpool.strategy;

import com.mycompany.carpool.models.Driver;
import com.mycompany.carpool.models.Trip;
import java.util.List;

public class DefaultDriverMatching implements DriverMatchingStrategy {

    @Override
    public Driver getMatchedDriver(List<Driver> availableDrivers, Trip trip) {

        //return the first driver available
        return availableDrivers.get(0);

    }

}
