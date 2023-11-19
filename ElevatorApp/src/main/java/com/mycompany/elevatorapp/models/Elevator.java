package com.mycompany.elevatorapp.models;

import com.mycompany.elevatorapp.enumpack.Direction;

public class Elevator {

    private int currentFloor;
    private Direction direction;

    public Elevator(int floor) {
        this.currentFloor = floor;
        this.direction = Direction.IDLE;

        System.out.println("Elevator initiated with current floor = " + currentFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
