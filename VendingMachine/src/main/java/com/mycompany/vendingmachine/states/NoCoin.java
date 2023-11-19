package com.mycompany.vendingmachine.states;

import com.mycompany.vendingmachine.exceptions.IllegalState;
import com.mycompany.vendingmachine.services.VendingMachineService;

public class NoCoin implements State {

    VendingMachineService vendingMachine;

    public NoCoin(VendingMachineService vendingMachineService) {
        this.vendingMachine = vendingMachineService;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.setBalance(amount);
        vendingMachine.setCurrentMachineState(vendingMachine.coinInserted);
    }

    @Override
    public void pressButton(int row) throws IllegalState {
        throw new IllegalState("No Balance to select items!");
    }

    @Override
    public void dispense(int row) throws IllegalState {
        throw new IllegalState("No Balance to disperse items!");
    }

}
