package parking.lot;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingLot {
    Long capacity;
    List<Car> cars;
    Operator operator;
}
