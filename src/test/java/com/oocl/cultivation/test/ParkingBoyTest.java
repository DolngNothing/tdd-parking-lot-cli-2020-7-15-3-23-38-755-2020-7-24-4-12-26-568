package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_car(){
        //give
        ParkingBoy parkingBoy=new ParkingBoy(new ParkingLot());
        Car car=new Car();
        //when
        CarTicket carTicket=parkingBoy.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_null_when_fetch_given_null_ticket(){
        //give
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        //when
        Car car=parkingBoy.fetch(null);
        assertNull(car);
    }
}
