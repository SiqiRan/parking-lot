package parking.lot.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import parking.lot.entity.Car;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ParkingReactiveService {
    ParkingReactiveRepository parkingReactiveRepository;

    public Mono<Car> getCarById(Long id) {
        return parkingReactiveRepository.getCarById(id);
    }

    public Mono<Car> parkCar(Car car) {
        return parkingReactiveRepository.parkCar(car);
    }
}
