package com.oocl.cultivation.test;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot{

    private final Map<CarTicket,Car> carTicketCarMap = new HashMap<>();

    private Integer capacity;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        if (carTicketCarMap.size() >= this.capacity) return null;
        CarTicket carTicket = new CarTicket();
        carTicketCarMap.put(carTicket,car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return carTicketCarMap.remove(carTicket);
    }

    public Map<CarTicket, Car> getCarTicketCarMap() {
        return carTicketCarMap;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getEmptyPostion(){
        return getCapacity() - getCarTicketCarMap().size();
    }

    public Double getEmptyRate(){
        return (double) (getEmptyPostion() / getCapacity());
    }
}


