package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_return_true_when_park_given_two_cars() {
        //give
        Car ferrari = new Car();
        Car porsche = new Car();

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);


        //when
        smartParkingBoy.park(ferrari);
        ParkResult porscheTicketResult = smartParkingBoy.park(porsche);


        //then
        assertNotNull(((ParkingLot) (parkingLots.get(1))).getCarTicketCarMap().get(porscheTicketResult.getCarTicket()));
    }

}
