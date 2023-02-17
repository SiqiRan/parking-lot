package parking.lot.operators;

import org.junit.jupiter.api.Test;
import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickUpCarTest {
    @Test
    void should_qet_car_by_id() throws CarNotFoundException {
        Car car = new Car(1L,1L);
        ParkingLot smallParkingLot = new ParkingLot(200L, new ArrayList<>(List.of(car)));
        ParkingBoy parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        assertEquals(car, parkingBoy.pickUp(1L).get());
    }

    @Test
    void should_pick_up_the_car() throws CarNotFoundException{
        Car car = new Car(1L,1L);
        ParkingLot smallParkingLot = new ParkingLot(200L, new ArrayList<>(List.of(car)));
        ParkingBoy parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        parkingBoy.pickUp(1L);
        assertEquals(0,smallParkingLot.getCars().size());
    }
}
