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
            if(parkingLot.getLeftPositions() > leastFilled.getLeftPositions()){
                leastFilled = parkingLot;
            }
        }
        return leastFilled;
    }
}
