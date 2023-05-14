package parking.lot.entity.valets;

import io.vavr.collection.List;
import io.vavr.control.Option;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.vehicles.Vehicle;

public interface Valet {

    ParkingLot chooseParkingLot(List<ParkingLot> parkingLots);

    Option<Vehicle> park(Vehicle vehicle);

    Option<Vehicle> pickUp(String plateNumber);

    void addParkingLot(ParkingLot parkingLot);

    List<ParkingLot> getParkingLots();

    Option<Vehicle> parkToParkingLot(Vehicle vehicleToPark, ParkingLot parkingLotToUse);

    String printParkingResult(Vehicle vehicle);
}
