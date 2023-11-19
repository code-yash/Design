package com.mycompany.carpool.managers;

import com.mycompany.carpool.models.Driver;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DriverManager {

    private Map<String, Driver> driverMap;
    private static volatile DriverManager driverManagerInstance;

    private DriverManager() {
        driverMap = new HashMap<>();

    }

    public static DriverManager getInstance() {
        if (driverManagerInstance == null) {
            synchronized (RiderManager.class) {
                if (driverManagerInstance == null) {
                    driverManagerInstance = new DriverManager();
                }
            }
        }
        return driverManagerInstance;
    }

    public void addDriver(Driver driver) {
        if (!driverMap.containsKey(driver.getDriverId())) {
            driverMap.put(driver.getDriverId(), driver);
            System.out.println("Driver " + driver.getDriverName() + " successfuly registered!");
        } else {
            System.out.println("Driver " + driver.getDriverName() + " already registered!");
        }
    }

    public List<Driver> getDrivers() {
        List<Driver> drivers = new LinkedList<>();
        for (String driver : driverMap.keySet()) {
            drivers.add(driverMap.get(driver));
        }
        return drivers;
    }

}
