package parking.lot;


import org.junit.jupiter.api.Test;
import parking.lot.operators.Operator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_park_car_when_there_is_empty_spot(){
        Operator parkingBoy = new ParkingBoy();
        ArrayList<Car> cars = new ArrayList<>();
        ParkingLot smallParkingLot = new ParkingLot(200L, cars,parkingBoy);
        Car car = new Car();
        String result = smallParkingLot.operator.park(car,smallParkingLot);
        assertEquals("Parking Successful!",result);
    }
}
