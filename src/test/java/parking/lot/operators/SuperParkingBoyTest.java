package parking.lot.operators;

import org.junit.jupiter.api.Test;
import parking.lot.Car;
import parking.lot.ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperParkingBoyTest {

    @Test
    void should_park_car_in_the_parking_lot_with_most_unoccupied_spots(){
        ParkingLot smallParkingLot = new ParkingLot(10L,new ArrayList<>());
        Car car = new Car(1L,1L);
        ParkingLot bigParkingLot = new ParkingLot(20L,new ArrayList<>(List.of(car)));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(List.of(smallParkingLot,bigParkingLot));
        Car secondCar = new Car(2L,2L);
        superParkingBoy.park(secondCar);
        assertEquals(1,superParkingBoy.getParkingLots().get(0).getCars().size());
    }
}