package parking.lot.operators;

import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;

import io.vavr.collection.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingManagerTest {
    @Test
    void should_park_car_in_the_parking_lot_with_most_unoccupied_spots(){
        ParkingBoy parkingBoy = new ParkingBoy(List.of(new ParkingLot(10L,List.empty(),"test parking lot")));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(new ParkingLot(20L,List.empty(),"another parking lot")));
        ParkingManager parkingManager = new ParkingManager(List.of(new ParkingLot(30L,List.empty(),"other parking lot")),List.of(parkingBoy,smartParkingBoy));
        Car car = new Car(1L,"car one",1L);
        Car secondCar = new Car(2L,"car two",2L);
        parkingManager.parkCar(car);
        assertEquals(secondCar,parkingManager.assignPark(secondCar));
        assertEquals(1,parkingManager.getParkingLots().get(0).getCars().size());
        assertEquals(1,parkingManager.getSubordinates().get(0).getParkingLots().get(0).getCars().size());
    }
}