package parking.lot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parking.lot.entity.Car;

@RestController
@RequestMapping("/parkingLot")
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable Long id){
        return parkingService.getCarById(id);
    }
}

