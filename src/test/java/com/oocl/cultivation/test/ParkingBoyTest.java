package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
