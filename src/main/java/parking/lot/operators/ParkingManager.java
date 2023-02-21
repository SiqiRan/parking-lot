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

    public String assignPark(Car carToAssignToPark) {
        for (Valet subordinate : subordinates) {
            if(subordinate.parkCar(carToAssignToPark).equals("Parking Successful!")){
                return "Parking Successful";
            }
        }
        return "No Empty Spot";
    }
}
