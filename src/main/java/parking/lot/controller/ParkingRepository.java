package parking.lot.controller;

import org.springframework.stereotype.Repository;
import parking.lot.entity.Car;

@Repository
public class ParkingRepository {

    public Car getCarById(Long carId) {
        return new Car(1L,1L);
    }
}
