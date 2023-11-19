package com.mycompany.carpool.managers;

import com.mycompany.carpool.models.Rider;
import java.util.HashMap;
import java.util.Map;

public class RiderManager {

    private Map<String, Rider> riderMap;
    private static volatile RiderManager riderManagerInstance;

    private RiderManager() {
        riderMap = new HashMap<>();

    }

    public static RiderManager getInstance() {
        if (riderManagerInstance == null) {
            synchronized (RiderManager.class) {
                if (riderManagerInstance == null) {
                    riderManagerInstance = new RiderManager();
                }
            }
        }
        return riderManagerInstance;
    }

    public void addRider(Rider rider) {
        if (!riderMap.containsKey(rider.getRiderId())) {
            riderMap.put(rider.getRiderId(), rider);
            System.out.println("Rider " + rider.getRiderName() + " successfuly registered!");
        } else {
            System.out.println("Rider " + rider.getRiderName() + " already registered!");
        }
    }

}
