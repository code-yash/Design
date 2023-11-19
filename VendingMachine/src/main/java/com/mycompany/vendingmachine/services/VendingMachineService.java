package com.mycompany.vendingmachine.services;

import com.mycompany.vendingmachine.dao.Inventory;
import com.mycompany.vendingmachine.exceptions.IllegalState;
import com.mycompany.vendingmachine.exceptions.ProductNotFoundException;
import com.mycompany.vendingmachine.exceptions.VendingMachineFullException;
import com.mycompany.vendingmachine.model.Product;
import com.mycompany.vendingmachine.states.CoinInserted;
import com.mycompany.vendingmachine.states.Dispense;
import com.mycompany.vendingmachine.states.NoCoin;
import com.mycompany.vendingmachine.states.State;

public class VendingMachineService {

    public NoCoin noCoin;
    public CoinInserted coinInserted;
    public Dispense dispense;
    public State currentMachineState;
    private int balance;
    Inventory inventory;

    public VendingMachineService() {
        this.balance = 0;
        noCoin = new NoCoin(this);
        coinInserted = new CoinInserted(this);
        dispense = new Dispense(this);
        currentMachineState = noCoin;
        inventory = Inventory.getInstance();
    }

    public State getCurrentMachineState() {
        return currentMachineState;
    }

    public void setCurrentMachineState(State currentMachineState) {
        this.currentMachineState = currentMachineState;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void dispenseProduct(int row) {
        Product product = null;
        try {
            product = inventory.getProduct(row);
            inventory.reduceProductQuantity(row);
            System.out.println("Product " + product.getProductName() + " dispensed successfully!");
            balance -= product.getProductPrice();
            System.out.println("Available Balance " + balance);
        } catch (ProductNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean checkProductAvailability(int itemRow) {

        try {
            Product product = inventory.getProduct(itemRow);

            if (product != null || inventory.checkQuantity(product) > 0) {
                return true;
            }
        } catch (ProductNotFoundException ex) {
            ex.getMessage();
        }
        return false;
    }

    public int checkProductPrice(int itemRow) {
        try {
            return inventory.getProduct(itemRow).getProductPrice();
        } catch (ProductNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return Integer.MAX_VALUE;
    }

    public void addProduct(String name, int price, int quantity) {
        Product product = new Product(name, price);
        try {
            inventory.addProduct(product, quantity);
        } catch (VendingMachineFullException ex) {
            ex.getMessage();
        }
    }

    public void insertCoin(int amount) {
        try {
            this.currentMachineState.insertCoin(amount);
            System.out.println(amount + " is added successfully!");
        } catch (IllegalState ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void pressButton(int itemRow) {
        try {
            this.currentMachineState.pressButton(itemRow);
            this.currentMachineState.dispense(itemRow);
        } catch (IllegalState ex) {
            System.out.println(ex.getMessage());
        }
    }
}
