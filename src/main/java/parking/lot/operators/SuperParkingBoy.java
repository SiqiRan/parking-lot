package parking.lot.operators;

import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

import java.util.List;

public class SuperParkingBoy extends Valet implements Operator{
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public String park(Car carToPark) {
        ParkingLot highestUnoccupiedRate = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getLeftPositions()/parkingLot.getCapacity() > highestUnoccupiedRate.getLeftPositions()/ parkingLot.getCapacity()){
                highestUnoccupiedRate = parkingLot;
            }
        }
        return parkCar(carToPark,highestUnoccupiedRate);
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }
}
