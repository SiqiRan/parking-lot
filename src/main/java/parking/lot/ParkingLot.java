package parking.lot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class ParkingLot {
    Long capacity;
    List<Car> cars;
}
