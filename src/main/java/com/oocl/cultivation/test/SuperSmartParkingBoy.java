package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends SmartParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingLot findLotWithMostEmptyPosition(List<ParkingLot> parkingLots) {
        List<ParkingLot> sortParkingLots = new ArrayList<>(parkingLots);
        sortParkingLots = sortParkingLots.stream().sorted(Comparator.comparing(ParkingLot::getEmptyRate).reversed()).collect(Collectors.toList());
        return sortParkingLots.get(0);
    }
}
