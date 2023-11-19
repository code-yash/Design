package com.mycompany.vendingmachine.states;

import com.mycompany.vendingmachine.exceptions.IllegalState;
import com.mycompany.vendingmachine.exceptions.InsufficientBalanceException;
import com.mycompany.vendingmachine.exceptions.ProductNotAvailableException;
import com.mycompany.vendingmachine.services.VendingMachineService;

public class CoinInserted implements State {

    VendingMachineService vendingMachine;

    public CoinInserted(VendingMachineService vendingMachineService) {
        this.vendingMachine = vendingMachineService;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.setBalance(vendingMachine.getBalance() + amount);
    }

    @Override
    public void pressButton(int itemRow) {
        try {
            if (!vendingMachine.checkProductAvailability(itemRow)) {
                throw new ProductNotAvailableException("Product not available now!");
            }

            if (vendingMachine.checkProductPrice(itemRow) <= vendingMachine.getBalance()) {
                vendingMachine.setCurrentMachineState(vendingMachine.dispense);
            } else {
                throw new InsufficientBalanceException("Insufficient Balance. Add more Balance!");
            }
        } catch (ProductNotAvailableException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dispense(int row) throws IllegalState {
        throw new IllegalState("Dispense Not possible!");
    }

}
