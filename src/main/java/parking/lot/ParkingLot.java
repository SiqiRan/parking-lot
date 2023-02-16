package parking.lot;

import lombok.AllArgsConstructor;
import parking.lot.operators.Operator;

import java.util.List;

@AllArgsConstructor
public class ParkingLot {
    Long capacity;
    List<Car> cars;
    Operator operator;
}
