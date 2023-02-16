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
            if(parkingLot.getCapacity() - parkingLot.getCars().size()  > leastFilled.getCapacity() - leastFilled.getCars().size()){
                leastFilled = parkingLot;
            }
        }
        if(leastFilled.getCars().size() == leastFilled.getCapacity()){
            return "No Empty Spot";
        }
        leastFilled.getCars().add(carToPark);
        return "Parking Successful!";
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }
}
