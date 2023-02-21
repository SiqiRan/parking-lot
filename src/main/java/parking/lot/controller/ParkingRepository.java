package parking.lot.controller;

import org.springframework.stereotype.Repository;
import parking.lot.ParkingDataBase;
import parking.lot.entity.Car;

@Repository
public class ParkingRepository {


    ParkingDataBase parkingDataBase;
    private ParkingRepository(){
        parkingDataBase = ParkingDataBase.getInstance();
    }
    public Car getCarById(Long carId) {
        return parkingDataBase.pickUp(carId);
    }

    public Car parkCar(Car car) {
        return parkingDataBase.park(car);
    }
}
