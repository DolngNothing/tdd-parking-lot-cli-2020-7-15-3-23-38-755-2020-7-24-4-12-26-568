package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<ParkingLot> sortParkingLots = new ArrayList<>(parkingLots);
        sortParkingLots = sortParkingLots.stream().sorted(Comparator.comparing(ParkingLot::getEmptyPostion).reversed()).collect(Collectors.toList());
        return sortParkingLots.get(0);
    }
}
