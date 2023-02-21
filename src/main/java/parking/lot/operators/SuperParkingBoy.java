package parking.lot.operators;

import parking.lot.entity.ParkingLot;
import parking.lot.exceptions.FullyOccupiedException;

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
        if(highestUnoccupiedRate.getOccupationRate() == 1){
            throw new FullyOccupiedException("No Empty Spot");
        }
        return highestUnoccupiedRate;
    }
}
