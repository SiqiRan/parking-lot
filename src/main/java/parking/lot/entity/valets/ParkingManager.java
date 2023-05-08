package parking.lot.entity.valets;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.valets.decorators.FirstEmptyFitDecorator;
import parking.lot.entity.vehicles.Car;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.vehicles.Vehicle;
import parking.lot.exceptions.CarNotFoundException;
import parking.lot.exceptions.FullyOccupiedException;

@Getter
@Setter
public class ParkingManager extends BasicValet {
    private List<BasicValet> subordinates;

    public ParkingManager() {
        subordinates = List.empty();
    }

    public List<BasicValet> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<BasicValet> subordinates) {
        this.subordinates = subordinates;
    }

    public ParkingManager(List<ParkingLot> parkingLots, List<BasicValet> subordinates) {
        super(parkingLots);
        this.subordinates = subordinates;
    }

    public ParkingManager(List<BasicValet> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        return new FirstEmptyFitDecorator(this).chooseParkingLot(parkingLots);
    }


    public Car assignPark(Car carToAssignToPark) {
        for (BasicValet subordinate : subordinates) {
            if(subordinate.park(carToAssignToPark).isDefined()){
                return carToAssignToPark;
            }
        }
        throw new FullyOccupiedException("All parking lots are occupied");
    }

    public Vehicle pickUpWithSubordinates(String carId){
        Option<Vehicle> pickUpResult = this.pickUp(carId);
        if(pickUpResult.isDefined()){
            return pickUpResult.get();
        }
        else {
            for (BasicValet subordinate : subordinates) {
                Option<Vehicle> subOrdinatePickUpResult = subordinate.pickUp(carId);
                if(subOrdinatePickUpResult.isDefined()){
                    return subOrdinatePickUpResult.get();
                }
            }
        }
        throw new CarNotFoundException("Can't find car in any parking lot");
    }
}
