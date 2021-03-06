package com.oocl.cultivation.test;

public class ParkResult {
    private final CarTicket carTicket;
    private final String message;

    public ParkResult(CarTicket carTicket, String message) {
        this.carTicket = carTicket;
        this.message = message;
    }

    public CarTicket getCarTicket() {
        return carTicket;
    }

    public String getMessage() {
        return message;
    }

}
