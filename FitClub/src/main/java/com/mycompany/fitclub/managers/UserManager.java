package com.mycompany.fitclub.managers;

import com.mycompany.fitclub.models.User;
import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, User> userMap;
    private static volatile UserManager userManagerInstance;

    private UserManager() {
        userMap = new HashMap<>();
    }

    public static UserManager getInstance() {

        if (userManagerInstance == null) {
            synchronized (UserManager.class) {
                if (userManagerInstance == null) {
                    return new UserManager();
                }
            }
        }
        return userManagerInstance;
    }

    public User registerUser(String userName) {
        User user = new User(userName);
        if (!userMap.containsKey(user.getUserId())) {
            userMap.put(user.getUserId(), user);
            System.out.println("User - " + user.getUserName() + " registered!");
        } else {
            System.out.println("User already Registered!");
        }
        return user;
    }

    public void removeUser(User user) {
        if (userMap.containsKey(user.getUserId())) {
            userMap.remove(user.getUserId());
            System.out.println("User - " + user.getUserName() + " removed!");
        } else {
            System.out.println("User NOT Registered!");
        }

    }

}
