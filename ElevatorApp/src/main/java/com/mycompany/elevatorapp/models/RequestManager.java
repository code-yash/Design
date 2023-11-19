package com.mycompany.elevatorapp.models;

import com.mycompany.elevatorapp.enumpack.Direction;
import com.mycompany.elevatorapp.enumpack.RequestType;
import java.util.NavigableSet;
import java.util.TreeSet;

public class RequestManager {

    private Elevator elevator;

    private static volatile RequestManager reqManagerInstance;
    private NavigableSet<Request> upRequest;
    private NavigableSet<Request> downRequest;

    public static RequestManager getInstance() {
        if (reqManagerInstance == null) {
            return new RequestManager();
        }
        return reqManagerInstance;
    }

    public RequestManager() {
        upRequest = new TreeSet<>((a, b) -> a.getDestFloor() - b.getDestFloor());
        downRequest = new TreeSet<>((a, b) -> b.getDestFloor() - a.getDestFloor());
        elevator = new Elevator(0);
    }

    public void callElevator(int srcFloor, int destFloor) {
        RequestType requestType = RequestType.EXTERNAL;
        Direction direction = (destFloor - srcFloor >= 0) ? Direction.UP : Direction.DOWN;
        Direction direction2 = (srcFloor - elevator.getCurrentFloor() >= 0) ? Direction.UP : Direction.DOWN;
        createRequest(srcFloor, srcFloor, direction2, requestType);
        System.out.println("Elevator call request placed for floor " + srcFloor);
        createRequest(srcFloor, destFloor, direction, requestType.INTERNAL);
        System.out.println("Elevator call request placed for floor " + destFloor);
    }

    private void createRequest(int srcFloor, int destFloor, Direction direction, RequestType requestType) {
        Request request = new Request(srcFloor, destFloor, requestType);
        if (direction == Direction.UP) {
            upRequest.add(request);
        } else {
            downRequest.add(request);
        }
    }

    public void takeElevator(int srcFloor, int destFloor) {
        RequestType requestType = RequestType.INTERNAL;
        Direction direction = (destFloor - srcFloor >= 0) ? Direction.UP : Direction.DOWN;
        createRequest(srcFloor, destFloor, direction, requestType.INTERNAL);
        System.out.println("Take Elevator request placed for floor " + destFloor);
    }

    public void processRequest() {

        //check whether to execute up or down based on distance initially
        processUpRequest();
        processDownRequest();

        System.out.println("Processed all Request!");
        elevator.setDirection(Direction.IDLE);
    }

    private void processUpRequest() {
        if (!upRequest.isEmpty()) {
            System.out.println("Elevator moving in UP direction");
            elevator.setDirection(Direction.UP);
            //Processing upRequests
            while (!upRequest.isEmpty()) {
                Request request = upRequest.pollFirst();
                elevator.setCurrentFloor(request.getDestFloor());
                System.out.println("Elevator stopped at: " + request.getDestFloor());
            }
        }
    }

    private void processDownRequest() {
        if (!downRequest.isEmpty()) {
            System.out.println("Elevator moving in DOWN direction");
            elevator.setDirection(Direction.DOWN);
            while (!downRequest.isEmpty()) {
                Request request = downRequest.pollFirst();
                elevator.setCurrentFloor(request.getDestFloor());
                System.out.println("Elevator stopped at: " + request.getDestFloor());
            }
        }

    }

    public Elevator getElevator() {
        return elevator;
    }

}
