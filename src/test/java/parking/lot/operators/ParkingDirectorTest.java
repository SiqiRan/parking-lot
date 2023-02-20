package parking.lot.operators;

import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingDirectorTest {

    @Test
    void should_get_required_information_in_a_parking_table(){
        ParkingBoy parkingBoy = new ParkingBoy(List.of(new ParkingLot(10L,new ArrayList<>(),"test parking lot")));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(new ParkingLot(20L,new ArrayList<>(),"another parking lot")));
        ParkingManager parkingManager = new ParkingManager(List.of(new ParkingLot(30L,new ArrayList<>(),"other parking lot")),List.of(parkingBoy,smartParkingBoy));
        Car car = new Car(1L,1L);
        Car secondCar = new Car(2L,2L);
        parkingManager.parkCar(car);
        parkingManager.assignPark(secondCar);
        ParkingDirector parkingDirector = new ParkingDirector(new ArrayList<>(List.of(parkingBoy,smartParkingBoy,parkingManager)));
        ParkingTable parkingTable = parkingDirector.getParkingTable();
        assertEquals(1,parkingTable.getParkingLots().get(0).getOccupiedPositions());
        assertEquals(1,parkingTable.getParkingLots().get(2).getOccupiedPositions());
    }
}