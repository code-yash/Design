package com.mycompany.foodkart.services;

public interface UserServices {

    public void registerUser(String userName, String gender, String phoneNo, String pinCode);

    public boolean loginUser(String userPhoneNo);

}
