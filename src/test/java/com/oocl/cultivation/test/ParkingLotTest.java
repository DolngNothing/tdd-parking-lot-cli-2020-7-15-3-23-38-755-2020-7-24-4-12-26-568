package com.oocl.cultivation.test;


import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_given_car(){
        //give
        ParkingLot parkingLot=new ParkingLot();
        Car car=new Car();
        //when
        CarTicket carTicket=parkingLot.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_ticket(){

    }
}
