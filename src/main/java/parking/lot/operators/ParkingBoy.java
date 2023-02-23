package parking.lot.operators;

import io.vavr.collection.List;
import parking.lot.entity.ParkingLot;

public class ParkingBoy extends Valet{

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
}
