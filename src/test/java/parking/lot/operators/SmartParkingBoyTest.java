package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import parking.lot.Car;
import parking.lot.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Getter
@Setter
class SmartParkingBoyTest {
    @Test
    void should_park_the_car_in_least_filled_parking_lot(){
        ParkingLot smallParkingLot = new ParkingLot(10L,new ArrayList<>());
        ParkingLot bigParkingLot = new ParkingLot(20L,new ArrayList<>());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(smallParkingLot,bigParkingLot));
        Car car = new Car(1L,1L);
        smartParkingBoy.park(car);
        assertEquals(1,smartParkingBoy.getParkingLots().get(1).getCars().size());
    }
}