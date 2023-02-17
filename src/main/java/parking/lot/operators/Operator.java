package parking.lot.operators;

import parking.lot.Car;
import parking.lot.exceptions.CarNotFoundException;

public interface Operator {

    Car pickUp(Long carId) throws CarNotFoundException;

}

