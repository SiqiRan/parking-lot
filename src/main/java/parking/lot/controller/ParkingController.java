package parking.lot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parking.lot.entity.Car;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parkingLot")
@AllArgsConstructor
public class ParkingController {

    ParkingService parkingService;
    ParkingReactiveService parkingReactiveService;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Car> getCarById(@PathVariable Long id){
        return parkingReactiveService.getCarById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car postCar(@RequestBody Car car){
        return parkingService.parkCar(car);
    }
}

