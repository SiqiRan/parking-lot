package parking.lot;

import parking.lot.exceptions.CarNotFoundException;

public interface Operator {
    String park(Car carToPark);

    Car pickUp(Long carId) throws CarNotFoundException;
}
