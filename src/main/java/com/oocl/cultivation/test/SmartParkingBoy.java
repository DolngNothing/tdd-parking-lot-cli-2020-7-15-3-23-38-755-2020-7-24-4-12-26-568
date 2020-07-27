package com.oocl.cultivation.test;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkResult park(Car car) {
        CarTicket carTicket = null;
        ParkingLot parkingLotWithMostEmptyPosition = findLotWithMostEmptyPosition(parkingLots);
        carTicket = parkingLotWithMostEmptyPosition.park(car);
        return new ParkResult(carTicket, carTicket == null ? "Not enough position." : null);
    }

    public ParkingLot findLotWithMostEmptyPosition(List<ParkingLot> parkingLots) {
        int mostEmptyValue = 0;
        int mostEmptyIndex = 0;
        int emptyValue = 0;

        for (int index = 0; index < parkingLots.size(); index++) {
            emptyValue = parkingLots.get(index).getEmptyPostion();
            if (emptyValue > mostEmptyValue) {
                mostEmptyIndex = index;
                mostEmptyValue = emptyValue;
            }
        }
        return parkingLots.get(mostEmptyIndex);
    }
}
