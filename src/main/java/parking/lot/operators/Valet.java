package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;

import java.util.List;
import java.util.Optional;


@Getter
@Setter
public class Valet {
     List<ParkingLot> parkingLots;

    public Valet(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

     public Optional<Car> parkCar(Car carToPark) {
        ParkingLot parkingLotToUse = chooseParkingLot();
        if(!checkIfAvailable(parkingLotToUse)){
            return Optional.empty();
        }
        parkingLotToUse.getCars().add(carToPark);
        parkingLotToUse.setOccupiedPositions(parkingLotToUse.getOccupiedPositions() + 1);
        parkingLotToUse.setOccupationRate((double) ((float)parkingLotToUse.getOccupiedPositions()/parkingLotToUse.getCapacity()));
        return Optional.of(carToPark);
    }

    ParkingLot chooseParkingLot(){
         return this.parkingLots.get(0);
    }

    public Optional<Car> pickUp(Long carId){
        Optional<Car> result = Optional.empty();
        for (ParkingLot parkingLot : parkingLots) {
            result = parkingLot.getCars().stream().filter(car -> car.getId().equals(carId)).findFirst();
            if(result.isPresent()){
                parkingLot.setOccupiedPositions(parkingLot.getOccupiedPositions() - 1);
                parkingLot.setOccupationRate((double) ((float)parkingLot.getOccupiedPositions()/parkingLot.getCapacity()));
                parkingLot.getCars().remove(result.get());
                break;
            }
        }
        return result;
    }

    private boolean checkIfAvailable(ParkingLot parkingLot){
        return !parkingLot.getOccupiedPositions().equals(parkingLot.getCapacity());
    }

     ParkingLot chooseParkingLotByLeftPositions() {
        ParkingLot leastFilled = this.parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            long leftPositions = parkingLot.getCapacity() - parkingLot.getOccupiedPositions();
            long leastLeftPositions = leastFilled.getCapacity() - leastFilled.getOccupiedPositions();
            if(leftPositions > leastLeftPositions){
                leastFilled = parkingLot;
            }
        }
        return leastFilled;
    }
}
