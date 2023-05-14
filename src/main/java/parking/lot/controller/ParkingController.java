package parking.lot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parking.lot.entity.vehicles.Car;
import parking.lot.entity.vehicles.Vehicle;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parking-lot")
@AllArgsConstructor
public class ParkingController {
    ParkingReactiveService parkingReactiveService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Vehicle> getVehicleById(@PathVariable Long id){
        return parkingReactiveService.getVehicleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Vehicle> park(@RequestBody Car car){
        return parkingReactiveService.park(car);
    }
}

