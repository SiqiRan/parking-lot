package parking.lot.controller;

import org.springframework.stereotype.Service;
import parking.lot.entity.Car;
import reactor.core.publisher.Mono;

@Service
public class ParkingReactiveService {
    ParkingReactiveRepository parkingReactiveRepository;

    public Mono<Car> getCarById(Long id) {
        return parkingReactiveRepository.getCarById(id);
    }

    public Mono<Car> parkCar(Car car) {
        return parkingReactiveRepository.parkCar(car);
    }
}
