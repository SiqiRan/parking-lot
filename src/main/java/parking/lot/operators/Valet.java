package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.Car;
import parking.lot.ParkingLot;

import java.util.List;


@Getter
@Setter
public class Valet {
    ParkingLot parkingLot;
    List<ParkingLot> parkingLots;

     String parkCar(Car carToPark, ParkingLot parkingLotToUse) {
        if(parkingLotToUse.getCars().size() == parkingLotToUse.getCapacity()){
            return "No Empty Spot";
        }
        parkingLotToUse.getCars().add(carToPark);
        return "Parking Successful!";
    }

    public Valet(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Valet(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
