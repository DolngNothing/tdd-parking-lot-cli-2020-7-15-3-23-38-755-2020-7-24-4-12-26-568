package com.oocl.cultivation.test;

public class CarTicket {
    private Car car;

    private String ticketMessage;

    public CarTicket(Car car) {
        this.car = car;
    }

    public CarTicket() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }

    public void setTicketMessage(String ticketMessage) {
        this.ticketMessage = ticketMessage;
    }
}
