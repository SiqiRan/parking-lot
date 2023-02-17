package parking.lot.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class ParkingLot {
    Long capacity;
    List<Car> cars;
    Long leftPositions;
    Long occupiedPositions;

    public ParkingLot(Long capacity, List<Car> cars) {
        this.capacity = capacity;
        this.cars = cars;
        this.leftPositions = capacity - cars.size();
        this.occupiedPositions = (long) cars.size();
    }
}
