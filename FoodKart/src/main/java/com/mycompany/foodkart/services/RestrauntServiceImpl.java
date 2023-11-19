package com.mycompany.foodkart.services;

import com.mycompany.foodkart.dao.RestrauntDao;
import com.mycompany.foodkart.dao.UserDao;
import com.mycompany.foodkart.exceptions.RestrauntAlreadyRegistered;
import com.mycompany.foodkart.exceptions.RestrauntNotRegistered;
import com.mycompany.foodkart.models.Restraunt;
import com.mycompany.foodkart.strategy.PriceStrategy;
import com.mycompany.foodkart.strategy.RatingStrategy;
import com.mycompany.foodkart.strategy.RestrauntSortStrategy;
import java.util.List;

public class RestrauntServiceImpl implements RestrauntService {

    RestrauntDao restrauntDao;
    UserDao userDao;

    public RestrauntServiceImpl() {
        this.restrauntDao = RestrauntDao.getInstance();
        this.userDao = UserDao.getInstance();
    }

    @Override
    public void registerRestraunt(String restrauntName, String listOfPinCode, String foodName, int foodItemPrice, int quantity) {
        Restraunt restraunt = new Restraunt(restrauntName, listOfPinCode.split("[/]"), foodName, foodItemPrice, quantity);
        try {
            restrauntDao.registerRestraunt(restraunt);
            System.out.println("Restraunt " + restraunt.getRestrauntName() + " Regisered Successfully!");
        } catch (RestrauntAlreadyRegistered ex) {
            System.out.println("Exception occurred: Restaurant already registered - " + ex.getMessage());
        }
    }

    @Override
    public void rateRestraunt(String restrauntName, int ratingScore, String comment) {
        Restraunt restraunt = null;
        try {
            restraunt = restrauntDao.getRestraunt(restrauntName);
            restraunt.addRestrauntRatings(ratingScore, comment);
            System.out.println("Restraunt rated successfully!");
        } catch (RestrauntNotRegistered ex) {
            System.out.println("Exception occurred: Restaurant not registered - " + ex.getMessage());
        }

    }

    @Override
    public void updateQuantity(String restrauntName, int addquantity) {
        Restraunt restraunt = null;
        try {
            restraunt = restrauntDao.getRestraunt(restrauntName);
            restraunt.updateQuantity(addquantity);
        } catch (RestrauntNotRegistered ex) {
            System.out.println("Exception occurred: Restaurant not registered - " + ex.getMessage());
        }

    }

    @Override
    public boolean placeOrder(String restrauntName, int quantity) {
        Restraunt restraunt = null;
        try {
            restraunt = restrauntDao.getRestraunt(restrauntName);
        } catch (RestrauntNotRegistered ex) {
            System.out.println("Exception occurred: Restaurant not registered - " + ex.getMessage());
            return false;
        }
        return restraunt.placeOrder(quantity);

    }

    @Override
    public List<Restraunt> listRestraunt(String orderBy) {
        RestrauntSortStrategy strategy = null;
        if (orderBy.toLowerCase().equals("rating")) {
            strategy = new RatingStrategy();
        } else if (orderBy.toLowerCase().equals("price")) {
            strategy = new PriceStrategy();
        }

        return strategy.findRestraunts(restrauntDao.getAllRestraunt(), userDao.getCurrentLoginUser().getPincode());
    }
}
