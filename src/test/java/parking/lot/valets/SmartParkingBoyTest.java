package parking.lot.valets;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import parking.lot.entity.vehicles.Car;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.valets.SmartParkingBoy;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_park_the_car_in_least_filled_parking_lot(){
        ParkingLot smallParkingLot = new ParkingLot(10L, List.empty(),"small parking lot");
        ParkingLot bigParkingLot = new ParkingLot(20L,List.empty(),"big parking lot");
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(smallParkingLot,bigParkingLot));
        Car car = new Car("1");
        smartParkingBoy.park(car);
        assertEquals(1,smartParkingBoy.getParkingLots().get(1).getVehicles().size());
    }
}