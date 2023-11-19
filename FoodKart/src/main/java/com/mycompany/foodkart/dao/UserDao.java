package com.mycompany.foodkart.dao;

import com.mycompany.foodkart.exceptions.UserNotPresent;
import com.mycompany.foodkart.exceptions.UserAlreadyPresent;
import com.mycompany.foodkart.models.User;
import java.util.HashMap;

public class UserDao {

    private static UserDao userDaoInstance;
    private HashMap<String, User> userMap;
    private User currentLoginUser;

    public UserDao() {
        this.currentLoginUser = null;
        userMap = new HashMap<>();
    }

    public static UserDao getInstance() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDao();
        }
        return userDaoInstance;
    }

    public void addUser(User user) throws UserAlreadyPresent {
        if (userMap.containsKey(user.getPhoneNo())) {
            throw new UserAlreadyPresent("User is already registered!");
        }
        userMap.put(user.getPhoneNo(), user);
    }

    public User getUser(String userPhoneNo) throws UserNotPresent {
        if (!userMap.containsKey(userPhoneNo)) {
            throw new UserNotPresent("User not present!");
        }
        return userMap.get(userPhoneNo);
    }

    public User getCurrentLoginUser() {
        return currentLoginUser;

    }

    public void setCurrentLoginUser(User currentUser) {
        this.currentLoginUser = currentUser;
    }

}
