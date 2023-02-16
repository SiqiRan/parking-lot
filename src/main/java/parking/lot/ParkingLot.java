package parking.lot;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ParkingLot {
    Long capacity;
    List<Car> cars;
}
