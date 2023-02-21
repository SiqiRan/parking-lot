package parking.lot.operators;

import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_park_the_car_in_least_filled_parking_lot(){
        ParkingLot smallParkingLot = new ParkingLot(10L,new ArrayList<>(),"small parking lot");
        ParkingLot bigParkingLot = new ParkingLot(20L,new ArrayList<>(),"big parking lot");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(smallParkingLot,bigParkingLot));
        Car car = new Car(1L,1L);
        smartParkingBoy.parkCar(car);
        assertEquals(1,smartParkingBoy.getParkingLots().get(1).getCars().size());
    }
}