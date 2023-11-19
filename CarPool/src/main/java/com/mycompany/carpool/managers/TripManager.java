package com.mycompany.carpool.managers;

import com.mycompany.carpool.models.Driver;
import com.mycompany.carpool.models.Location;
import com.mycompany.carpool.models.Rider;
import com.mycompany.carpool.models.Trip;
import com.mycompany.carpool.strategy.DefaultDriverMatching;
import com.mycompany.carpool.strategy.DefaultPrice;
import com.mycompany.carpool.strategy.DriverMatchingStrategy;
import com.mycompany.carpool.strategy.PricingStrategy;
import java.util.HashMap;
import java.util.Map;

public class TripManager {

    private Map<String, Trip> tripMap;
    private static volatile TripManager tripManagerInstance;
//    private Trip currTrip;

    private TripManager() {
        tripMap = new HashMap<>();

    }

    public static TripManager getInstance() {
        if (tripManagerInstance == null) {
            synchronized (TripManager.class) {
                if (tripManagerInstance == null) {
                    tripManagerInstance = new TripManager();
                }
            }
        }
        return tripManagerInstance;
    }

    public void createTrip(Rider rider, int startL, int endL, int seatsRequired) {
        Trip currTrip = new Trip();
        Location startLoc = new Location(startL);
        Location endLoc = new Location(endL);

        currTrip.setStartLoc(startLoc);
        currTrip.setEndLoc(endLoc);
        currTrip.setRider(rider);
        currTrip.setBookedSeats(seatsRequired);

        DriverMatchingStrategy driverStrategy = new DefaultDriverMatching();
        PricingStrategy pricingStrategy = new DefaultPrice();
        DriverManager driverManager = DriverManager.getInstance();

        Driver allocatedDriver = driverStrategy.getMatchedDriver(driverManager.getDrivers(), currTrip);
        currTrip.setDriver(allocatedDriver);

        double price = pricingStrategy.getTripPrice(currTrip);
        System.out.println("price:" + price);

        currTrip.setPrice(price);
        addTrip(currTrip);
        System.out.println("Trip Price: " + getTripPrice(currTrip));
    }

    public double getTripPrice(Trip currTrip) {
        return currTrip.getPrice();
    }

    private void addTrip(Trip currTrip) {
        tripMap.put(currTrip.getTripId(), currTrip);
    }

}
