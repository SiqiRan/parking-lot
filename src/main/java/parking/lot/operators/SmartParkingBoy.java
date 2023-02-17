package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

import java.util.List;


@Getter
@Setter
public class SmartParkingBoy extends Valet implements Operator{


    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public String park(Car carToPark) {
        ParkingLot leastFilled = this.parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getLeftPositions() > leastFilled.getLeftPositions()){
                leastFilled = parkingLot;
            }
        }
        return parkCar(carToPark, leastFilled);
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }
}
