package parking.lot.entity.valets;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.vehicles.Vehicle;

import static parking.lot.utils.ParkingLotUtils.checkIfAvailable;


@Getter
@Setter
public class BasicValet implements Valet{

    protected List<ParkingLot> parkingLots;

    public BasicValet() {
        this.parkingLots = List.empty();
    }

    public BasicValet(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots){
        return parkingLots.get(0);
    }

    public Option<Vehicle> park(Vehicle vehicleToPark) {
        if(!checkIfAvailable(this.parkingLots)){
            return Option.none();
        }
        ParkingLot parkingLotToUse = chooseParkingLot(this.parkingLots);
        parkingLotToUse.setVehicles(parkingLotToUse.getVehicles().append(vehicleToPark));
        parkingLotToUse.setOccupiedPositions(parkingLotToUse.getOccupiedPositions() + 1);
        parkingLotToUse.setOccupationRate((double) ((float)parkingLotToUse.getOccupiedPositions()/parkingLotToUse.getCapacity()));
        return Option.of(vehicleToPark);
    }

    public Option<Vehicle> parkToParkingLot(Vehicle vehicleToPark, ParkingLot parkingLotToUse){
        parkingLotToUse.setVehicles(parkingLotToUse.getVehicles().append(vehicleToPark));
        parkingLotToUse.setOccupiedPositions(parkingLotToUse.getOccupiedPositions() + 1);
        parkingLotToUse.setOccupationRate((double) ((float)parkingLotToUse.getOccupiedPositions()/parkingLotToUse.getCapacity()));
        return Option.of(vehicleToPark);
    }

    public Option<Vehicle> pickUp(String plateNumber){
        Option<Vehicle> result = Option.none();
        for (ParkingLot parkingLot : parkingLots) {
            result = parkingLot.getVehicles().find(car -> car.getPlateNumber().equals(plateNumber));
            if(result.isDefined()){
                parkingLot.setOccupiedPositions(parkingLot.getOccupiedPositions() - 1);
                parkingLot.setOccupationRate((double) ((float)parkingLot.getOccupiedPositions()/parkingLot.getCapacity()));
                parkingLot.setVehicles(parkingLot.getVehicles().remove(result.get()));
                break;
            }
        }
        return result;
    }

    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots = this.parkingLots.append(parkingLot);
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
