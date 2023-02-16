package parking.lot;

import lombok.AllArgsConstructor;
import parking.lot.exceptions.CarNotFoundException;
import parking.lot.operators.Operator;

@AllArgsConstructor
public class ParkingBoy implements Operator {
    @Override
    public String park(Car carToPar,ParkingLot parkingLot) {
        return "Parking Successful!";
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }
}
