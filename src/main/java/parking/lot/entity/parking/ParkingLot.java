package parking.lot.entity.parking;

import lombok.Getter;
import lombok.Setter;

import io.vavr.collection.List;
import parking.lot.entity.vehicles.Car;

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
        this.occupationRate = (double)cars.size()/capacity;
    }

    public Double getOccupationRate() {
        return (double) occupiedPositions / capacity;
    }

    public Double getEmptyRate(){
        return 1 - (double)occupiedPositions / capacity;
    }
    public boolean isEmpty(){
        return capacity > occupiedPositions;
    }

    public Long getEmptyPositions(){
        return capacity - occupiedPositions;
    }
}
