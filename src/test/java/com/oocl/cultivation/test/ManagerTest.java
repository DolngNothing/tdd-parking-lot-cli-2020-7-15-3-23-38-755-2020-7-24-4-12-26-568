package com.oocl.cultivation.test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    @Test
    void should_return_true_when_park_given_cars() {
        List<ParkingLot> parkingLots=new ArrayList<>();
        parkingLots.add(new ParkingLot(4));
        parkingLots.add(new ParkingLot(3));
        List<ParkingStrategy> strategies=new ArrayList<>();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy= new SmartParkingBoy(parkingLots);
        strategies.add(superSmartParkingBoy);
        strategies.add(smartParkingBoy);
        Manager manager = new Manager(strategies);
        Car ferrari = new Car();
        Car bmw = new Car();

        //then
        manager.park(superSmartParkingBoy,ferrari);
        ParkResult bmwResult = superSmartParkingBoy.park(bmw);

        //then
        assertEquals(true, ((ParkingLot) (parkingLots.get(1))).getCarTicketCarMap().equals(bmwResult.getCarTicket()));
    }
}
