package parking.lot.valets;

import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.entity.valets.ParkingBoy;
import parking.lot.exceptions.CarNotFoundException;

import io.vavr.collection.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PickUpCarTest {
    @Test
    void should_qet_car_by_id() throws CarNotFoundException {
        Car car = new Car(1L,"car",1L);
        ParkingLot smallParkingLot = new ParkingLot(200L, List.of(car),"small parking lot");
        ParkingBoy parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        assertEquals(car, parkingBoy.pickUp(1L).get());
    }

    @Test
    void should_pick_up_the_car() throws CarNotFoundException{
        Car car = new Car(1L,"car",1L);
        Car secondCar = new Car(2L,"car two",2L);
        ParkingLot smallParkingLot = new ParkingLot(200L, List.of(car),"small parking lot");
        ParkingBoy parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        parkingBoy.parkCar(secondCar);
        parkingBoy.pickUp(2L);
        assertEquals(1,smallParkingLot.getCars().size());
    }
}
