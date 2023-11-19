package com.mycompany.foodkart.models;

class FoodItem {

    String foodName;
    int foodPrice;
    int foodQuantity;

    public FoodItem(String foodName, int foodPrice, int foodQuantity) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void updateFoodQuantity(int foodQuantity) {
        this.foodQuantity += foodQuantity;
    }

}
