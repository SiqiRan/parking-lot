package parking.lot.operators;

import org.junit.jupiter.api.Test;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;

import io.vavr.collection.List;
import parking.lot.entity.operators.SuperParkingBoy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperParkingBoyTest {

    @Test
    void should_park_car_in_the_parking_lot_with_most_unoccupied_spots(){
        ParkingLot smallParkingLot = new ParkingLot(10L,List.empty(),"small parking lot");
        Car car = new Car(1L,"car",1L);
        ParkingLot bigParkingLot = new ParkingLot(20L,List.of(car),"small parking lot");
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(List.of(smallParkingLot,bigParkingLot));
        Car secondCar = new Car(2L,"car two",2L);
        superParkingBoy.parkCar(secondCar);
        assertEquals(1,superParkingBoy.getParkingLots().get(0).getCars().size());
    }
}