package parking.lot.operators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class SmartParkingBoy implements Operator{
    List<ParkingLot> parkingLots;

    @Override
    public String park(Car carToPark) {
        ParkingLot leastFilled = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getLeftPositions() > leastFilled.getLeftPositions()){
                leastFilled = parkingLot;
            }
        }
        return parkCar(carToPark, leastFilled);
    }

    private static String parkCar(Car carToPark, ParkingLot parkingLotToUse) {
        if(parkingLotToUse.getCars().size() == parkingLotToUse.getCapacity()){
            return "No Empty Spot";
        }
        parkingLotToUse.getCars().add(carToPark);
        return "Parking Successful!";
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }
}
