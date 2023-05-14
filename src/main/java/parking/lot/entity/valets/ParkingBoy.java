package parking.lot.entity.valets;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.parking.ParkingLot;

@Getter
@Setter
public class ParkingBoy extends BasicValet {

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
}
