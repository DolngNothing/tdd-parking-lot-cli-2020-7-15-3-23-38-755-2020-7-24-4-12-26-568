package com.oocl.cultivation.test;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingLot findLotWithMostEmptyPosition(List<ParkingLot> parkingLots) {
        double mostemptyRateValue = 0.0;
        int mostEmptyRateIndex = 0;
        double emptyRateValue = 0.0;
        int emptyValue = 0;
        for (int index = 0; index < parkingLots.size(); index++) {
            emptyValue = parkingLots.get(index).getEmptyPostion();
            emptyRateValue = (double) (emptyValue / parkingLots.get(index).getCapacity());
            if (emptyRateValue > mostemptyRateValue) {
                mostEmptyRateIndex = index;
                mostemptyRateValue = emptyRateValue;
            }
        }
        return parkingLots.get(mostEmptyRateIndex);
    }
}
