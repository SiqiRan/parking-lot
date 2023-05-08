package parking.lot.entity.valets;

import io.vavr.collection.List;
import parking.lot.entity.parking.ParkingLot;


public class ParkingBoy extends BasicValet {

    public ParkingBoy() {
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
}
