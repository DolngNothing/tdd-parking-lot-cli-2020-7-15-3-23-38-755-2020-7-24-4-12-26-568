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

    public FetchResult fetch(CarTicket carTicket) {
        if(carTicket==null) return new FetchResult(null,"Please provide your parking ticket.");
        Car car = parkingLot.fetch(carTicket);
        return new FetchResult(car,null);
    }

    public String queried(CarTicket carTicket){
        if(carTicket.getUsed()) return "Unrecognized parking ticket.";
        return null;
    }

}
