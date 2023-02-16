package parking.lot.operators;


import org.junit.jupiter.api.Test;
import parking.lot.Car;
import parking.lot.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {
    @Test
    void should_park_car_when_there_is_empty_spot(){
        ArrayList<Car> cars = new ArrayList<>();
        ParkingLot smallParkingLot = new ParkingLot(200L, cars);
        Operator parkingBoy = new ParkingBoy(smallParkingLot);
        Car car = new Car(1L,1L);
        String result = parkingBoy.park(car);
        assertEquals("Parking Successful!",result);
        assertEquals(1L,smallParkingLot.getCars().size());
    }

    @Test
    void should_check_the_empty_spot_before_park(){
        ArrayList<Car> cars = new ArrayList<>(List.of(new Car(1L,1L)));
        ParkingLot smallParkingLot = new ParkingLot(1L, cars);
        Operator parkingBoy = new ParkingBoy(smallParkingLot);
        Car car = new Car(1L,1L);
        String result = parkingBoy.park(car);
        assertEquals("No Empty Spot",result);
    }
}
