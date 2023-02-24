package parking.lot.entity.operators;

import io.vavr.collection.List;
import parking.lot.entity.ParkingLot;

public class SuperParkingBoy extends Valet {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot() {
        ParkingLot highestUnoccupiedRate = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getOccupationRate() >highestUnoccupiedRate.getOccupationRate()){
                highestUnoccupiedRate = parkingLot;
            }
        }
        return highestUnoccupiedRate;
    }
}
