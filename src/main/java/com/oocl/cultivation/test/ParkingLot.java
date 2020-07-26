package com.oocl.cultivation.test;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<CarTicket> carTickets = new ArrayList<CarTicket>();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket(car);
        carTickets.add(carTicket);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        if (carTickets.contains(carTicket)) {
            carTickets.remove(carTicket);
            return carTicket.getCar();
        }
        return null;
    }
}


