package parking.lot.valets;


import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.entity.valets.ParkingBoy;
import parking.lot.entity.valets.Valet;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_park_car_when_there_is_empty_spot(){
        List<Car> cars = List.of();
        ParkingLot smallParkingLot = new ParkingLot(200L, cars, "smallParkingLot");
        Valet parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        Car car = new Car(1L,"car",1L);
        Car result = parkingBoy.parkCar(car).get();
        assertEquals(car,result);
        assertEquals(1L,smallParkingLot.getCars().size());
    }

    @Test
    void should_check_the_empty_spot_before_park(){
        List<Car> cars = List.of(new Car(1L,"car",1L));
        ParkingLot smallParkingLot = new ParkingLot(1L, cars,"smallParkingLot");
        Valet parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        Car car = new Car(1L,"car",1L);
        assertFalse(parkingBoy.parkCar(car).isDefined());
    }
}
