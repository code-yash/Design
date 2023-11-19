package com.mycompany.foodkart.dao;

import com.mycompany.foodkart.models.Order;
import com.mycompany.foodkart.models.User;
import java.util.HashMap;
import java.util.List;

public class OrderDao {

    HashMap<String, List<Order>> userOrdersMap;

    public List<Order> getUserOrders(User user) {
        return userOrdersMap.get(user.getPhoneNo());
    }
}
