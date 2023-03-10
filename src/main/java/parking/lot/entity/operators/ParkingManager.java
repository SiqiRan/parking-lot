package parking.lot.entity.operators;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;
import parking.lot.exceptions.FullyOccupiedException;

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
        return chooseParkingLotByLeftPositions();
    }


    public Car assignPark(Car carToAssignToPark) {
        for (Valet subordinate : subordinates) {
            if(subordinate.parkCar(carToAssignToPark).isDefined()){
                return carToAssignToPark;
            }
        }
        throw new FullyOccupiedException("All parking lots are occupied");
    }

    public Car pickUpWithSubordinates(Long carId){
        Option<Car> pickUpResult = this.pickUp(carId);
        if(pickUpResult.isDefined()){
            return pickUpResult.get();
        }
        else {
            for (Valet subordinate : subordinates) {
                Option<Car> subOrdinatePickUpResult = subordinate.pickUp(carId);
                if(subOrdinatePickUpResult.isDefined()){
                    return subOrdinatePickUpResult.get();
                }
            }
        }
        throw new CarNotFoundException("Can't find car in any parking lot");
    }
}
