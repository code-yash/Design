package com.mycompany.foodkart;

import com.mycompany.foodkart.models.Restraunt;
import com.mycompany.foodkart.services.RestrauntServiceImpl;
import com.mycompany.foodkart.services.UserServiceImpl;
import java.util.List;

public class FoodKart {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        RestrauntServiceImpl restrauntServices = new RestrauntServiceImpl();

        userService.registerUser("Pralove", "Male", "phoneNumber-1", "HSR");
        userService.registerUser("Nitesh", "male", "phoneNumber-2", "BTM");
        userService.registerUser("Vatsai", "male", "phoneNumber-3", "BTM");

        userService.loginUser("phoneNumber-1");

        restrauntServices.registerRestraunt("Food Court-1", "BTM/HSR", "NI Thai", 100, 5);
        restrauntServices.registerRestraunt("Food Court-2", "BTM", "Burger", 120, 3);

        userService.loginUser("phoneNumber-2");

        restrauntServices.registerRestraunt("Food Court-3", "BTM", "SI Thai", 150, 1);

        userService.loginUser("phoneNumber-3");

        List<Restraunt> restrauntList = restrauntServices.listRestraunt("Price");

        for (Restraunt restraunt : restrauntList) {
            System.out.println(restraunt.getRestrauntName() + "  " + restraunt.getFoodItemName());
        }

        if (restrauntServices.placeOrder("Food Court-1", 2)) {
            System.out.println("Order Placed Successfully");
        } else {
            System.out.println("Cannot place Order!");
        }

        if (restrauntServices.placeOrder("Food Court-2", 7)) {
            System.out.println("Order Placed Successfully");
        } else {
            System.out.println("Cannot place Order!");
        }

        restrauntServices.rateRestraunt("Food Court-2", 3, "Good Food!");
        restrauntServices.rateRestraunt("Food Court-1", 5, "Nice Food!");
        restrauntServices.rateRestraunt("Food Court-3", 4, "Nice Food!");

        restrauntList = restrauntServices.listRestraunt("rating");

        for (Restraunt restraunt : restrauntList) {
            System.out.println(restraunt.getRestrauntName() + " " + restraunt.getFoodItemName());
        }

    }
}
