package parking.lot.controller;

import org.springframework.stereotype.Repository;
import parking.lot.ParkingDataBase;
import parking.lot.entity.Car;

@Repository
public class ParkingRepository {

    ParkingDataBase parkingDataBase = ParkingDataBase.getInstance();
    public Car getCarById(Long carId) {
        return new Car(1L,1L);
    }

    public Car parkCar(Car car) {
        return new Car(2L, 2L);
    }
}
