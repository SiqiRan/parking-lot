package parking.lot.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ParkingLot {
    Long capacity;
    List<Car> cars;
    Long occupiedPositions;
    Double occupationRate;
    String name;
    public ParkingLot(Long capacity, List<Car> cars, String name) {
        this.capacity = capacity;
        this.cars = cars;
        this.name = name;
        this.occupiedPositions = (long) cars.size();
        this.occupationRate = 0.0;
    }
}
