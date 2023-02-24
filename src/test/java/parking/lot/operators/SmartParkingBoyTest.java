package parking.lot.operators;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.entity.operators.SmartParkingBoy;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_park_the_car_in_least_filled_parking_lot(){
        ParkingLot smallParkingLot = new ParkingLot(10L, List.empty(),"small parking lot");
        ParkingLot bigParkingLot = new ParkingLot(20L,List.empty(),"big parking lot");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(smallParkingLot,bigParkingLot));
        Car car = new Car(1L,"car",1L);
        smartParkingBoy.parkCar(car);
        assertEquals(1,smartParkingBoy.getParkingLots().get(1).getCars().size());
    }
}