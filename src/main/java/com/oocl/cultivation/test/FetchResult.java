package com.oocl.cultivation.test;

public class FetchResult {
    private Car car;
    private String message;

    public FetchResult() {
    }

    public FetchResult(Car car, String message) {
        this.car = car;
        this.message = message;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
