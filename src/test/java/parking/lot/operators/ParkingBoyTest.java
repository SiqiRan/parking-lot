package parking.lot.operators;


import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingBoyTest {
    @Test
    void should_park_car_when_there_is_empty_spot(){
        ArrayList<Car> cars = new ArrayList<>();
        ParkingLot smallParkingLot = new ParkingLot(200L, cars, "smallParkingLot");
        Valet parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        Car car = new Car(1L,"car",1L);
        Car result = parkingBoy.parkCar(car).get();
        assertEquals(car,result);
        assertEquals(1L,smallParkingLot.getCars().size());
    }

    @Test
    void should_check_the_empty_spot_before_park(){
        ArrayList<Car> cars = new ArrayList<>(List.of(new Car(1L,"car",1L)));
        ParkingLot smallParkingLot = new ParkingLot(1L, cars,"smallParkingLot");
        Valet parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        Car car = new Car(1L,"car",1L);
        assertTrue(parkingBoy.parkCar(car).isEmpty());
    }
}
