package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

import java.util.List;
import java.util.Optional;


@Getter
@Setter
public class Valet {
     List<ParkingLot> parkingLots;

     public String parkCar(Car carToPark) {
        ParkingLot parkingLotToUse = chooseParkingLot();
        if(parkingLotToUse.getCars().size() == parkingLotToUse.getCapacity()){
            return "No Empty Spot";
        }
        parkingLotToUse.getCars().add(carToPark);
        parkingLotToUse.setOccupiedPositions(parkingLotToUse.getOccupiedPositions() + 1);
        parkingLotToUse.setOccupationRate((double) (parkingLotToUse.getOccupiedPositions()/parkingLotToUse.getCapacity()));

        return "Parking Successful!";
    }

    public Valet(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    ParkingLot chooseParkingLot(){
         return this.parkingLots.get(0);
    }

    Optional<Car> pickUp(Long carId) throws CarNotFoundException{
        Optional<Car> result = Optional.empty();
        for (ParkingLot parkingLot : parkingLots) {
            result = parkingLot.getCars().stream().filter(car -> car.getId().equals(carId)).findFirst();
            if(result.isPresent()){
                parkingLot.setLeftPositions(parkingLot.getLeftPositions() + 1);
                parkingLot.setOccupiedPositions(parkingLot.getOccupiedPositions() - 1);
                parkingLot.getCars().remove(result.get());
                break;
            }
        }
        return result;
    }
}
