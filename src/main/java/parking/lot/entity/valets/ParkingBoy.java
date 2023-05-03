package parking.lot.entity.valets;

import io.vavr.collection.List;
import parking.lot.entity.ParkingLot;


public class ParkingBoy extends Valet{

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
}
