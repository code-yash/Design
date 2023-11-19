package com.mycompany.vendingmachine.states;

import com.mycompany.vendingmachine.exceptions.IllegalState;

public interface State {

    public void insertCoin(int amount) throws IllegalState;

    public void pressButton(int row) throws IllegalState;

    public void dispense(int row) throws IllegalState;

}
