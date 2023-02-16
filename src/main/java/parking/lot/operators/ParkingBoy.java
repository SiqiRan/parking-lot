package parking.lot.operators;

import lombok.AllArgsConstructor;
import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

@AllArgsConstructor
public class ParkingBoy implements Operator {
    ParkingLot parkingLot;
    @Override
    public String park(Car carToPark) {
        if(parkingLot.getCars().size() == parkingLot.getCapacity()){
            parkingLot.setLeftPositions(parkingLot.getLeftPositions() - 1);
            parkingLot.setOccupiedPositions(parkingLot.getOccupiedPositions() + 1);
            return "No Empty Spot";
        }
        parkingLot.getCars().add(carToPark);
        return "Parking Successful!";
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }
}
