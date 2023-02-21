package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;

import java.util.List;

@Getter
@Setter
public class ParkingManager extends Valet{
    List<Valet> subordinates;

    public ParkingManager(List<ParkingLot> parkingLots,List<Valet> subordinates) {
        super(parkingLots);
        this.subordinates = subordinates;
    }

    @Override
    public ParkingLot chooseParkingLot() {
        return this.getParkingLots().get(0);
    }

    public Car assignPark(Car carToAssignToPark) {
        boolean parkSuccessful = false;
        for (Valet subordinate : subordinates) {
            try {
                subordinate.parkCar(carToAssignToPark);
                parkSuccessful = true;
            }catch (FullyOccupiedException e){
                continue;
            }
        }
        if(parkSuccessful){
            return carToAssignToPark;
        }
        throw new FullyOccupiedException("All parking lots are occupied");
    }
}
