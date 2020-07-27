package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SuperSmartParkingBoyTest {
    @Test
    void should_return_true_when_park_given_two_cars() {
        //give
        Car ferrari = new Car();

        Car bmw = new Car();

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(4));
        parkingLots.add(new ParkingLot(3));

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        superSmartParkingBoy.park(ferrari);

        ParkResult bmwResult = superSmartParkingBoy.park(bmw);

        //then
        assertNotNull(((ParkingLot) (parkingLots.get(1))).getCarTicketCarMap().get(bmwResult.getCarTicket()));
    }
}
