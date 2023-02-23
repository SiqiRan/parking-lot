package parking.lot.operators;

import parking.lot.entity.ParkingLot;

import java.util.List;

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
