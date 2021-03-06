package com.oocl.cultivation.test;


import java.util.List;

public class ParkingBoy implements ParkingStrategy {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    private static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
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
        return new ParkResult(carTicket, carTicket == null ? NOT_ENOUGH_POSITION : null);
    }


    public FetchResult fetch(CarTicket carTicket) {
        if (carTicket == null) return new FetchResult(null, PLEASE_PROVIDE_YOUR_PARKING_TICKET);
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCarTicketCarMap().get(carTicket) != null) {
                car = parkingLot.fetch(carTicket);
            }
        }
        return new FetchResult(car, car == null ? UNRECOGNIZED_PARKING_TICKET : null);
    }

    public String query(FetchResult fetchResult) {
        return fetchResult.getMessage();
    }
}
