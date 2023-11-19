package com.mycompany.foodkart.services;

import com.mycompany.foodkart.models.Restraunt;
import java.util.List;

public interface RestrauntService {

    void registerRestraunt(String restrauntName, String listOfPinCode,
            String foodName, int foodItemPrice, int quantity);

    void rateRestraunt(String restrauntName, int rating, String comment);

    void updateQuantity(String restrauntName, int addquantity);

    boolean placeOrder(String restrauntName, int quantity);

    List<Restraunt> listRestraunt(String orderBy);
}
