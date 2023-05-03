package parking.lot.entity.valets;

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

    public Valet() {
    }

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
        ParkingLot parkingLot = parkingLots.get(0);
        for (ParkingLot currenParkinglot : parkingLots) {
            if(currenParkinglot.isEmpty()){
                parkingLot = currenParkinglot;
            }
        }
        return parkingLot;
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
        ParkingLot mostEmptyPositions = this.parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getEmptyPositions() > mostEmptyPositions.getEmptyPositions()){
                mostEmptyPositions = parkingLot;
            }
        }
        return mostEmptyPositions;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
