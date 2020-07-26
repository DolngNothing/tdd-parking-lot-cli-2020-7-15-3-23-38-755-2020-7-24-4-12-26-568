package com.oocl.cultivation.test;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<CarTicket> carTickets = new ArrayList<CarTicket>();

    private Integer capacity;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        if (carTickets.size() >= this.capacity) return null;
        CarTicket carTicket = new CarTicket(car);
        carTickets.add(carTicket);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        if (carTickets.contains(carTicket)) {
            carTickets.remove(carTicket);
            carTicket.setUsed(true);
            return carTicket.getCar();
        }
        return null;
    }

    public List<CarTicket> getCarTickets() {
        return carTickets;
    }

    public void setCarTickets(List<CarTicket> carTickets) {
        this.carTickets = carTickets;
    }

}


