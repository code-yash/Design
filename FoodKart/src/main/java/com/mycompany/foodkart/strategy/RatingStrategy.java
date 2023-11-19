package com.mycompany.foodkart.strategy;

import com.mycompany.foodkart.helper.MatchRestrauntUser;
import com.mycompany.foodkart.models.Restraunt;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RatingStrategy implements RestrauntSortStrategy {

    @Override
    public List<Restraunt> findRestraunts(List<Restraunt> restrauntsList, String userPinCode) {
        List<Restraunt> restrauntList = MatchRestrauntUser.getServicableRestraunts(restrauntsList, userPinCode);
        Collections.sort(restrauntList, (Restraunt a, Restraunt b) -> Double.compare(b.getRestrauntRating(), a.getRestrauntRating()));

        return restrauntList;
    }

}
