package com.mycompany.foodkart.models;

import com.mycompany.foodkart.enums.Gender;

public class User {

    String userName;
    String phoneNo;
    Gender gender;
    String pincode;

    public User(String userName, String phoneNo, Gender gender, String pincode) {
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.pincode = pincode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
