package parking.lot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parking.lot.entity.Car;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parking-lot")
@AllArgsConstructor
public class ParkingController {
    ParkingReactiveService parkingReactiveService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Car> getCarById(@PathVariable Long id){
        return parkingReactiveService.getCarById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Car> postCar(@RequestBody Car car){
        return parkingReactiveService.parkCar(car);
    }
}

