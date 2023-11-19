package com.mycompany.vendingmachine.states;

import com.mycompany.vendingmachine.exceptions.IllegalState;
import com.mycompany.vendingmachine.services.VendingMachineService;

public class Dispense implements State {

    VendingMachineService vendingMachine;

    public Dispense(VendingMachineService vendingMachineService) {
        this.vendingMachine = vendingMachineService;
    }

    @Override
    public void insertCoin(int amount) throws IllegalState {
        throw new IllegalState("Machine is Dispensing Items!");
    }

    @Override
    public void pressButton(int row) throws IllegalState {
        throw new IllegalState("Machine is Dispensing Items!");
    }

    @Override
    public void dispense(int row) {
        vendingMachine.dispenseProduct(row);
        vendingMachine.setCurrentMachineState(vendingMachine.coinInserted);
    }

}
