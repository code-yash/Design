package com.mycompany.vendingmachine;

import com.mycompany.vendingmachine.services.VendingMachineService;

public class VendingMachine {

    public static void main(String[] args) {
        System.out.println("Welcome to Vending Machine");
        VendingMachineService vendingMachine = new VendingMachineService();
        vendingMachine.addProduct("Coffee", 10, 3);
        vendingMachine.pressButton(1);
        vendingMachine.insertCoin(20);
        vendingMachine.pressButton(1);
        vendingMachine.pressButton(1);
        vendingMachine.pressButton(1);
        vendingMachine.pressButton(1);
        vendingMachine.addProduct("Tea", 5, 2);
        vendingMachine.insertCoin(10);
        vendingMachine.pressButton(2);
        vendingMachine.pressButton(2);

    }
}
