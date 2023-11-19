package com.mycompany.foodkart.strategy;

import com.mycompany.foodkart.helper.MatchRestrauntUser;
import com.mycompany.foodkart.models.Restraunt;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceStrategy implements RestrauntSortStrategy {

    @Override
    public List<Restraunt> findRestraunts(List<Restraunt> restrauntsList, String userPinCode) {
        List<Restraunt> restrauntList = MatchRestrauntUser.getServicableRestraunts(restrauntsList, userPinCode);
        Collections.sort(restrauntList, new Comparator<Restraunt>() {

            @Override
            public int compare(Restraunt a, Restraunt b) {
                return Double.compare(a.getFoodItemPrice(), b.getFoodItemPrice());
            }
        });

        return restrauntList;
    }

}
