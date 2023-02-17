package parking.lot.operators;

import org.junit.jupiter.api.Test;
import parking.lot.Car;
import parking.lot.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingManagerTest {
    @Test
    void should_park_car_in_the_parking_lot_with_most_unoccupied_spots(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10L,new ArrayList<>()));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(new ParkingLot(20L,new ArrayList<>())));
        ParkingManager parkingManager = new ParkingManager(List.of(new ParkingLot(30L,new ArrayList<>())),List.of(parkingBoy,smartParkingBoy));
        Car car = new Car(1L,1L);
        Car secondCar = new Car(2L,2L);
        parkingManager.parkCar(car);
        parkingManager.assignPark(secondCar);
        assertEquals(1,parkingManager.getParkingLots().get(0).getCars().size());
        assertEquals(1,parkingManager.getEmployees().get(0).getParkingLot().getCars().size());
    }
}