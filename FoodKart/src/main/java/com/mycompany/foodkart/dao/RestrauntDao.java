package com.mycompany.foodkart.dao;

import com.mycompany.foodkart.exceptions.RestrauntNotRegistered;
import com.mycompany.foodkart.exceptions.RestrauntAlreadyRegistered;
import com.mycompany.foodkart.models.Restraunt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestrauntDao {

    private HashMap<String, Restraunt> restrauntMap;
    private static RestrauntDao restrauntDaoInstance;

    public RestrauntDao() {
        this.restrauntMap = new HashMap<>();
    }

    public static RestrauntDao getInstance() {
        if (restrauntDaoInstance == null) {
            restrauntDaoInstance = new RestrauntDao();
        }

        return restrauntDaoInstance;
    }

    public void registerRestraunt(Restraunt restraunt) throws RestrauntAlreadyRegistered {
        if (restrauntMap.containsKey(restraunt.getRestrauntName())) {
            throw new RestrauntAlreadyRegistered("Restraunt Already Registered!");
        }
        restrauntMap.put(restraunt.getRestrauntName(), restraunt);
    }

    public Restraunt getRestraunt(String restrauntName) throws RestrauntNotRegistered {
        if (!restrauntMap.containsKey(restrauntName)) {
            throw new RestrauntNotRegistered("Restraunt Not Registered!");
        }
        return restrauntMap.get(restrauntName);
    }

    public List<Restraunt> getAllRestraunt() {
        List<Restraunt> list = new ArrayList<>();
        for (String name : restrauntMap.keySet()) {
            list.add(restrauntMap.get(name));
        }
        return list;
    }
}
