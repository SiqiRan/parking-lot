package parking.lot.operators;

import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

public interface Operator {
    String park(Car carToPark);

    Car pickUp(Long carId) throws CarNotFoundException;

    ParkingLot chooseParkingLot();
}

