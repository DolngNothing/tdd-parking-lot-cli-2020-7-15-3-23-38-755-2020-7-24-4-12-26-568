package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingStrategy> strategies = new ArrayList<>();

    public Manager(List<ParkingStrategy> strategies) {
        super();
        this.strategies = strategies;
    }

    public ParkResult park(ParkingStrategy parkingStrategy, Car car) {
        return parkingStrategy.park(car);
    }
}
