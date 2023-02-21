package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;
import parking.lot.exceptions.FullyOccupiedException;

import java.util.List;
import java.util.Optional;

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

    public Car pickUpWithSubordinates(Long carId){
        Optional<Car> pickUpResult = this.pickUp(carId);
        if(pickUpResult.isPresent()){
            return pickUpResult.get();
        }
        else {
            for (Valet subordinate : subordinates) {
                Optional<Car> subOrdinatePickUpResult = subordinate.pickUp(carId);
                if(subOrdinatePickUpResult.isPresent()){
                    return subOrdinatePickUpResult.get();
                }
            }
        }
        throw new CarNotFoundException("Can't find car in any parking lot");
    }
}
