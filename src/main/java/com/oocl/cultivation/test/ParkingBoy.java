package com.oocl.cultivation.test;


import java.util.List;

public class ParkingBoy implements ParkingStrategy {

    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingBoy() {

    }

    public ParkResult park(Car car) {
        CarTicket carTicket = null;
        for (ParkingLot parkingLot : parkingLots) {
            carTicket = parkingLot.park(car);
            if (carTicket != null) break;
        }
        return new ParkResult(carTicket, carTicket == null ? "Not enough position." : null);
    }

    // todo fengzhuang
    public FetchResult fetch(CarTicket carTicket) {
        if (carTicket == null) return new FetchResult(null, "Please provide your parking ticket.");
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCarTickets().contains(carTicket)) {
                car = parkingLot.fetch(carTicket);
            }
        }
        return new FetchResult(car, null);
    }
// todo
    public String queried(CarTicket carTicket) {
        if (carTicket.getUsed()) return "Unrecognized parking ticket.";
        return null;
    }

}
