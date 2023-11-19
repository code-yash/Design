/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.foodkart.helper;

import com.mycompany.foodkart.models.Restraunt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yashs
 */
public class MatchRestrauntUser {

    public static List<Restraunt> getServicableRestraunts(List<Restraunt> restrauntsList, String userPinCode) {
        List<Restraunt> list = new ArrayList<>();
        for (Restraunt restraunt : restrauntsList) {
            if (restraunt.checkPinCodeSevicable(userPinCode)) {
                list.add(restraunt);
            }
        }
        return list;
    }

}
