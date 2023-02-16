package parking.lot;


import org.junit.jupiter.api.Test;
import parking.lot.operators.Operator;
import parking.lot.operators.ParkingBoy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {
    @Test
    void should_park_car_when_there_is_empty_spot(){
        ArrayList<Car> cars = new ArrayList<>();
        ParkingLot smallParkingLot = new ParkingLot(200L, cars);
        Operator parkingBoy = new ParkingBoy(smallParkingLot);
        Car car = new Car();
        String result = parkingBoy.park(car);
        assertEquals("Parking Successful!",result);
        assertEquals(1L,smallParkingLot.cars.size());
    }

    @Test
    void should_check_the_empty_spot_before_park(){
        ArrayList<Car> cars = new ArrayList<>(List.of(new Car()));
        ParkingLot smallParkingLot = new ParkingLot(1L, cars);
        Operator parkingBoy = new ParkingBoy(smallParkingLot);
        Car car = new Car();
        String result = parkingBoy.park(car);
        assertEquals("No Empty Spot",result);
    }
}
