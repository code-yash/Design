package com.mycompany.carpool;

import com.mycompany.carpool.managers.DriverManager;
import com.mycompany.carpool.managers.RiderManager;
import com.mycompany.carpool.managers.TripManager;
import com.mycompany.carpool.models.Driver;
import com.mycompany.carpool.models.Rider;

public class CarPool {

    public static void main(String[] args) {
        System.out.println("Welcome to Car Pooling System");
        Rider r1 = new Rider("Yash");
        Rider r2 = new Rider("Akshay");
        Rider r3 = new Rider("Rima");

        RiderManager riderManager = RiderManager.getInstance();
        riderManager.addRider(r1);
        riderManager.addRider(r2);
        riderManager.addRider(r3);

        Driver d1 = new Driver("Ram", 4, true);
        Driver d2 = new Driver("Shyam", 4, true);

        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(d1);
        driverManager.addDriver(d2);

        TripManager tripManager = TripManager.getInstance();
        tripManager.createTrip(r1, 1, 10, 1);

    }
}
