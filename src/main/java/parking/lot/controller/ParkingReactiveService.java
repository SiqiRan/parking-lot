package parking.lot.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import parking.lot.entity.vehicles.Vehicle;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ParkingReactiveService {
    ParkingReactiveRepository parkingReactiveRepository;

    public Mono<Vehicle> getVehicleById(Long id) {
        return parkingReactiveRepository.getVehicleById(id);
    }

    public Mono<Vehicle> park(Vehicle vehicle) {
        return parkingReactiveRepository.park(vehicle);
    }
}
