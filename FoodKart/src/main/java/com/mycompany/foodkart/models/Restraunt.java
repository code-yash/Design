package com.mycompany.foodkart.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class Restraunt {

    String id;
    String restrauntName;
    HashSet<String> servicePinCode;
    FoodItem foodItem;
    Rating rating;

    public Restraunt(String restrauntName, String[] servicePinCode, String foodItemName, int foodItemPrice, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.restrauntName = restrauntName;
        this.servicePinCode = new HashSet<>(Arrays.asList(servicePinCode));
        this.foodItem = new FoodItem(foodItemName, foodItemPrice, quantity);
        this.rating = new Rating();
    }

    public String getRestrauntName() {
        return this.restrauntName;
    }

    public boolean checkPinCodeSevicable(String pinCode) {
        if (servicePinCode.contains(pinCode)) {
            return true;
        }
        return false;
    }

    public String getFoodItemName() {
        return foodItem.getFoodName();
    }

    public int getFoodItemPrice() {
        return foodItem.getFoodPrice();
    }

    public double getRestrauntRating() {
        return rating.getAvgRating();
    }

    public void updateQuantity(int quantityToAdd) {
        this.foodItem.updateFoodQuantity(quantityToAdd);
    }

    public boolean checkEnoughQuantity(int quantity) {
        return this.foodItem.getFoodQuantity() > quantity;
    }

    public void addRestrauntRatings(int ratings, String comment) {
        this.rating.addRatingAndComment(ratings, comment);
    }

    public boolean placeOrder(int quantity) {
        if (this.checkEnoughQuantity(quantity)) {
            foodItem.foodQuantity -= quantity;
            return true;
        }
        return false;
    }

}
