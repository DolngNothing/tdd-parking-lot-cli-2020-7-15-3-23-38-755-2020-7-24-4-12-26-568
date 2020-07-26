package com.oocl.cultivation.test;


public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(CarTicket carTicket) {
        return parkingLot.fetch(carTicket);
    }

    public String queried(CarTicket carTicket){
        if(carTicket.getUsed()) return "Unrecognized parking ticket.";
        return null;
    }

}
