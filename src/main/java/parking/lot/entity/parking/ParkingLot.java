package parking.lot.entity.parking;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.vehicles.Vehicle;

@Setter
@Getter
public class ParkingLot {
    Long capacity;
    List<Vehicle> vehicles;
    Long occupiedPositions;
    Double occupationRate;
    String name;

    public ParkingLot(Long capacity, List<Vehicle> vehicles, String name) {
        this.capacity = capacity;
        this.vehicles = vehicles;
        this.name = name;
        this.occupiedPositions = (long) vehicles.size();
        this.occupationRate = (double) vehicles.size()/capacity;
    }

    public Double getOccupationRate() {
        return (double) occupiedPositions / capacity;
    }

    public Double getEmptyRate(){
        return 1 - (double)occupiedPositions / capacity;
    }

    public boolean hasSpace(){
        return capacity > occupiedPositions;
    }

    public Long getEmptyPositions(){
        return capacity - occupiedPositions;
    }
}
