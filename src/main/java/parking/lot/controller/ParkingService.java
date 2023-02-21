package parking.lot.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import parking.lot.entity.Car;

@Service
@AllArgsConstructor
public class ParkingService {

    ParkingRepository parkingRepository;
    public Car getCarById(Long carId) {
        return parkingRepository.getCarById(carId);
    }

    public Car parkCar(Car car) {
        return parkingRepository.parkCar(car);
    }
}
