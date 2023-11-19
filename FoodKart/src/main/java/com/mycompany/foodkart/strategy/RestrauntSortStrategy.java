package com.mycompany.foodkart.strategy;

import com.mycompany.foodkart.models.Restraunt;
import java.util.List;

public interface RestrauntSortStrategy {

    List<Restraunt> findRestraunts(List<Restraunt> restrauntsList, String userPinCode);

}
