package parking.lot.entity.valets;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.parking.ParkingLot;

@Getter
@Setter
public class SuperParkingBoy extends BasicValet {
    public SuperParkingBoy() {
    }

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot highestEmptyRate = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getEmptyRate() > highestEmptyRate.getEmptyRate()){
                highestEmptyRate = parkingLot;
            }
        }
        return highestEmptyRate;
    }
}
