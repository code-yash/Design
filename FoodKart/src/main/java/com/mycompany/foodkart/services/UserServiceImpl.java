package com.mycompany.foodkart.services;

import com.mycompany.foodkart.dao.UserDao;
import com.mycompany.foodkart.enums.Gender;
import com.mycompany.foodkart.exceptions.UserAlreadyPresent;
import com.mycompany.foodkart.exceptions.UserNotPresent;
import com.mycompany.foodkart.models.User;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl implements UserServices {

    UserDao userDao;

    public UserServiceImpl() {
        this.userDao = UserDao.getInstance();
    }

    @Override
    public void registerUser(String userName, String gender, String phoneNo, String pinCode) {
        User user;
        user = new User(userName, phoneNo, gender.toLowerCase().equals("male") ? Gender.MALE : Gender.FEMALE,
                pinCode);
        try {
            userDao.addUser(user);
            System.out.println("User " + user.getUserName() + " registered Successfully");
        } catch (UserAlreadyPresent ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean loginUser(String userPhoneNo) {
        User user = null;
        try {
            user = userDao.getUser(userPhoneNo);
        } catch (UserNotPresent ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user != null) {
            userDao.setCurrentLoginUser(user);
            System.out.println("User " + user.getUserName() + " Login Successful!");
            return true;
        }
        return false;
    }

}
