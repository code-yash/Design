package com.mycompany.fitclub.models;

import java.util.UUID;

public class User implements Comparable {

    private String userId;
    private String userName;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int compareTo(Object b) {
        User user2 = (User) b;
        return this.userId.compareTo(user2.userId);
    }

}
