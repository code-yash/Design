package com.mycompany.elevatorapp;

import com.mycompany.elevatorapp.models.RequestManager;

public class ElevatorApp {

    public static void main(String[] args) {
        RequestManager rm = new RequestManager();

        rm.takeElevator(rm.getElevator().getCurrentFloor(), 5);
        rm.takeElevator(rm.getElevator().getCurrentFloor(), 3);
        rm.callElevator(4, 0);
        rm.takeElevator(rm.getElevator().getCurrentFloor(), 1);
        rm.takeElevator(rm.getElevator().getCurrentFloor(), 2);

        rm.processRequest();
        System.out.println(rm.getElevator().getCurrentFloor());

        rm.callElevator(1, 0);
        rm.processRequest();

    }
}
