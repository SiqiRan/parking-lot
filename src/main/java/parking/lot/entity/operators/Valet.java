package parking.lot.entity.operators;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;


@Getter
@Setter
public class Valet {
     List<ParkingLot> parkingLots;
    public Valet(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

     public Option<Car> parkCar(Car carToPark) {
        ParkingLot parkingLotToUse = chooseParkingLot();
        if(!checkIfAvailable(parkingLotToUse)){
            return Option.none();
        }
        parkingLotToUse.setCars(parkingLotToUse.getCars().append(carToPark));
        parkingLotToUse.setOccupiedPositions(parkingLotToUse.getOccupiedPositions() + 1);
        parkingLotToUse.setOccupationRate((double) ((float)parkingLotToUse.getOccupiedPositions()/parkingLotToUse.getCapacity()));
        return Option.of(carToPark);
    }

    ParkingLot chooseParkingLot(){
         return this.parkingLots.get(0);
    }

    public Option<Car> pickUp(Long carId){
        Option<Car> result = Option.none();
        for (ParkingLot parkingLot : parkingLots) {
            result = parkingLot.getCars().find(car -> car.getCarId().equals(carId));
            if(result.isDefined()){
                parkingLot.setOccupiedPositions(parkingLot.getOccupiedPositions() - 1);
                parkingLot.setOccupationRate((double) ((float)parkingLot.getOccupiedPositions()/parkingLot.getCapacity()));
                parkingLot.setCars(parkingLot.getCars().remove(result.get()));
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
