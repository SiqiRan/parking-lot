package parking.lot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parking.lot.entity.Car;

@RestController
@RequestMapping("/parkingLot")
@AllArgsConstructor
public class ParkingController {

    ParkingService parkingService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable Long id){
        return parkingService.getCarById(id);
    }
}

