package parking.lot.operators;

import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

public class ParkingBoy extends Valet implements Operator {

    public ParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public String park(Car carToPark) {
       return parkCar(carToPark,parkingLot);
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }
}
