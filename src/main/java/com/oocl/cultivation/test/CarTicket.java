package com.oocl.cultivation.test;

public class CarTicket {
    private Car car;

    private Boolean isUsed;

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

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }
}
