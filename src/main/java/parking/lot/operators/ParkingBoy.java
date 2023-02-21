package parking.lot.operators;

import parking.lot.entity.ParkingLot;

import java.util.List;

public class ParkingBoy extends Valet{

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
}
