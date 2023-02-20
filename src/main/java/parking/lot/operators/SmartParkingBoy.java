package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.ParkingLot;

import java.util.List;


@Getter
@Setter
public class SmartParkingBoy extends Valet {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot() {
        ParkingLot leastFilled = this.parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            long leftPositions = parkingLot.getCapacity() - parkingLot.getOccupiedPositions();
            long leastLeftPositions = leastFilled.getCapacity() - leastFilled.getOccupiedPositions();
            if(leftPositions > leastLeftPositions){
                leastFilled = parkingLot;
            }
        }
        return leastFilled;
    }
}
