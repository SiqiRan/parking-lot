package parking.lot.valets;


import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import parking.lot.entity.valets.BasicValet;
import parking.lot.entity.vehicles.Car;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.valets.ParkingBoy;
import parking.lot.entity.vehicles.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_park_car_when_there_is_empty_spot(){
        List<Vehicle> vehicles = List.of();
        ParkingLot smallParkingLot = new ParkingLot(200L, vehicles, "smallParkingLot");
        BasicValet parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        Vehicle vehicle = new Car("1");
        Vehicle result = parkingBoy.park(vehicle).get();
        assertEquals(vehicle,result);
        assertEquals(1L,smallParkingLot.getVehicles().size());
    }

    @Test
    void should_check_the_empty_spot_before_park(){
        List<Vehicle> vehicles = List.of(new Car("1"));
        ParkingLot smallParkingLot = new ParkingLot(1L, vehicles,"smallParkingLot");
        BasicValet parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        Car car = new Car("1");
        assertFalse(parkingBoy.park(car).isDefined());
    }
}
