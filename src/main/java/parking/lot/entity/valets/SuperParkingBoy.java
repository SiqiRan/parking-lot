package parking.lot.entity.valets;

import io.vavr.collection.List;
import parking.lot.entity.ParkingLot;

public class SuperParkingBoy extends Valet {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot() {
        ParkingLot highestEmptyRate = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getEmptyRate() > highestEmptyRate.getEmptyRate()){
                highestEmptyRate = parkingLot;
            }
        }
        return highestEmptyRate;
    }
}
