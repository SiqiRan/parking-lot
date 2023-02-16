package parking.lot;

import lombok.Getter;
import lombok.Setter;
import parking.lot.operators.Operator;

import java.util.List;

@Getter
@Setter
public class ParkingLot {
    Long capacity;
    List<Car> cars;
    Operator operator;
}
