package com.oocl.cultivation.test;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkResult park(Car car) {
        CarTicket carTicket = null;
        ParkingLot parkingLotWithMostEmptyPosition = findLotWithMostEmptyPosition(parkingLots);
        carTicket = parkingLotWithMostEmptyPosition.park(car);
        return new ParkResult(carTicket, carTicket == null ? "Not enough position." : null);
    }

    public ParkingLot findLotWithMostEmptyPosition(List<ParkingLot> parkingLots){
        Double mostemptyRateValue=0.0;
        int mostEmptyRateIndex=0;
        Double emptyRateValue=0.0;
        int emptyValue=0;
        for(int index=0;index<parkingLots.size();index++){
            emptyValue=parkingLots.get(index).getCapacity()-parkingLots.get(index).getCarTickets().size();


            if(emptyRateValue>mostemptyRateValue){
                mostEmptyRateIndex=index;
                mostemptyRateValue=emptyRateValue;
            }
        }
        return parkingLots.get(mostEmptyRateIndex);
    }
}