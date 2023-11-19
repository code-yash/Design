package com.mycompany.elevatorapp.models;

import com.mycompany.elevatorapp.enumpack.Direction;
import com.mycompany.elevatorapp.enumpack.RequestType;

public class Request {

    private int srcFloor;
    private int destFloor;
    private Direction direction;
    private RequestType requestType;

    public Request(int srcFloor, int destFloor, RequestType requestType) {
        this.srcFloor = srcFloor;
        this.destFloor = destFloor;
        this.requestType = requestType;
        this.direction = (destFloor - srcFloor >= 0) ? Direction.UP : Direction.DOWN;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public int getSrcFloor() {
        return srcFloor;
    }

    public int getDestFloor() {
        return destFloor;
    }

    public Direction getDirection() {
        return direction;
    }

}
