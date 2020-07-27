package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //give
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        //when
        ParkResult parkResult = parkingBoy.park(car);
        //then
        assertNotNull(parkResult.getCarTicket());
    }

    @Test
    void should_return_car_when_fetch_given_carTicket() {
        //give
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Car car = new Car();
        ParkResult parkResult = parkingBoy.park(car);
        //when
        FetchResult fetchResult = parkingBoy.fetch(parkResult.getCarTicket());
        //then
        assertNotNull(fetchResult.getCar());
    }

    @Test
    void should_return_error_message_when_query_given_used_ticket() {
        //give
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkResult parkResult = parkingBoy.park(new Car());
        parkingBoy.fetch(parkResult.getCarTicket());
        parkingBoy.fetch(parkResult.getCarTicket());
        //when
        String message = parkingBoy.queried(parkResult.getCarTicket());
        //then
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_return_error_message_when_fetch_given_null_ticket() {
        //give
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        FetchResult fetchResult = parkingBoy.fetch(null);
        assertEquals("Please provide your parking ticket.", fetchResult.getMessage());
    }

    @Test
    void should_return_error_message_when_park_given_over_capacity() {
        //give
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        //when
        ParkResult parkResult = parkingBoy.park(new Car());
        //then
        assertEquals("Not enough position.", parkResult.getMessage());
    }

    @Test
    void should_return_right_ticket_when_park_given_over_one_capacity() {
        //give
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        //when
        ParkResult parkResult = parkingBoy.park(new Car());
        //then
        assertNotNull(parkResult.getCarTicket());
    }

    @Test
    void should_return_right_car_when_fetch_given_over_one_capacity() {
        //give
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        Car porsche = new Car();
        ParkResult parkResult = parkingBoy.park(porsche);
        //when
        FetchResult fetchResult = parkingBoy.fetch(parkResult.getCarTicket());
        //then
        assertNotNull(fetchResult.getCar());
    }
}
