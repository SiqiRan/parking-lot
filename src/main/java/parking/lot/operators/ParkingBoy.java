package parking.lot.operators;

import parking.lot.ParkingLot;

import java.util.List;

public class ParkingBoy extends Valet{

    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot() {
        return parkingLots.get(0);
    }

}
