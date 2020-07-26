package com.oocl.cultivation.test;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_given_car() {
        //give
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        CarTicket carTicket = parkingLot.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_given_ticket() {
        //give
        ParkingLot parkingLot = new ParkingLot();
        Car parkedCar = new Car();
        CarTicket carTicket = new CarTicket(parkedCar);
        carTicket = parkingLot.park(parkedCar);
        //when
        Car car = parkingLot.fetch(carTicket);
        //then
        assertNotNull(car);
    }

    @Test
    void should_return_null_when_fetch_given_wrong_ticket() {
        //give
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = new CarTicket();
        //when
        Car car = parkingLot.fetch(carTicket);
        assertEquals(null, car);
    }

    @Test
    void should_return_null_when_fetch_given_used_ticket() {
        //give
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = new CarTicket(new Car());
        //when
        Car car = parkingLot.fetch(carTicket);
        Car noCar = parkingLot.fetch(carTicket);
        assertEquals(null, noCar);
    }

    @Test
    void should_return_right_car_when_fetch_given_different_ticket() {
        //give
        ParkingLot parkingLot = new ParkingLot();
        Car ferrari = new Car();
        Car porsche = new Car();
        CarTicket ferrariTicket = parkingLot.park(ferrari);
        CarTicket porscheTicket = parkingLot.park(porsche);

        //when
        Car car1 = parkingLot.fetch(ferrariTicket);
        Car car2 = parkingLot.fetch(porscheTicket);
        assertEquals(ferrari, car1);
        assertEquals(porsche, car2);
    }

}
