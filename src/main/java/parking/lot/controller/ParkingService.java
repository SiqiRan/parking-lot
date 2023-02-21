package parking.lot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parking.lot.entity.Car;

@Service
public class ParkingService {

    @Autowired
    ParkingRepository parkingRepository;
    public Car getCarById(Long carId) {
        return parkingRepository.getCarById(carId);
    }
}
