package com.oocl.cultivation.test;


import java.util.ArrayList;
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


    public FetchResult fetch(CarTicket carTicket) {
        if (carTicket == null) return new FetchResult(null, "Please provide your parking ticket.");
        Car car = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCarTicketCarMap().get(carTicket)!=null) {
                car = parkingLot.fetch(carTicket);
            }
        }
        return new FetchResult(car, null);
    }
// todo
    public String query(CarTicket carTicket) {
        if (carTicket.getUsed()) return "Unrecognized parking ticket.";
        return null;
    }

    public static void main(String[] args) {
        //give
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Car car = new Car();
        ParkResult parkResult = parkingBoy.park(car);
        System.out.println(parkResult.getCarTicket());
        //when
        FetchResult fetchResult = parkingBoy.fetch(parkResult.getCarTicket());

        System.out.println(fetchResult.getCar());
    }

}
