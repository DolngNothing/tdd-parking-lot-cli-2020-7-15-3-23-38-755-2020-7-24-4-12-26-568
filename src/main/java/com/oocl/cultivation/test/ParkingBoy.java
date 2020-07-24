package com.oocl.cultivation.test;


import java.util.ArrayList;
import java.util.*;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot=parkingLot;
    }

    public CarTicket park(Car car){
        return parkingLot.park(car);
    }

}
