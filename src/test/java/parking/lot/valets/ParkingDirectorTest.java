package parking.lot.valets;

import org.junit.jupiter.api.Test;
import parking.lot.entity.directors.ParkingDirector;
import parking.lot.entity.vehicles.Car;
import parking.lot.entity.parking.ParkingLot;

import io.vavr.collection.List;
import parking.lot.entity.valets.ParkingBoy;
import parking.lot.entity.valets.ParkingManager;
import parking.lot.entity.valets.ParkingTable;
import parking.lot.entity.valets.SmartParkingBoy;

import static org.junit.jupiter.api.Assertions.*;

class ParkingDirectorTest {

    @Test
    void should_get_required_information_in_a_parking_table(){
        ParkingBoy parkingBoy = new ParkingBoy(List.of(new ParkingLot(10L,List.empty(),"test parking lot")));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(new ParkingLot(20L,List.empty(),"another parking lot")));
        ParkingManager parkingManager = new ParkingManager(List.of(new ParkingLot(30L,List.empty(),"other parking lot")),List.of(parkingBoy,smartParkingBoy));
        Car car = new Car("1");
        Car secondCar = new Car("2");
        parkingManager.park(car);
        parkingManager.assignPark(secondCar);
        ParkingDirector parkingDirector = new ParkingDirector(List.of(parkingBoy,smartParkingBoy,parkingManager));
        ParkingTable parkingTable = parkingDirector.getParkingTable();
        assertEquals(1,parkingTable.getParkingLots().get(0).getOccupiedPositions());
        assertEquals(1,parkingTable.getParkingLots().get(2).getOccupiedPositions());
    }
}