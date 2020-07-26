package com.oocl.cultivation.test;


public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkResult park(Car car) {
        CarTicket carTicket = parkingLot.park(car);
        ParkResult parkResult=new ParkResult(carTicket,carTicket==null ? "Not enough position." : null);
        return parkResult;
    }

    public String fetch(CarTicket carTicket) {
        if(parkingLot.fetch(carTicket)==null) return "Please provide your parking ticket.";
        return null;
    }

    public String queried(CarTicket carTicket){
        if(carTicket.getUsed()) return "Unrecognized parking ticket.";
        return null;
    }

}
