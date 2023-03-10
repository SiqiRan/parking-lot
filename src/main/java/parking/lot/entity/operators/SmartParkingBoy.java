package parking.lot.entity.operators;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.ParkingLot;

@Getter
@Setter
public class SmartParkingBoy extends Valet {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot() {
        return chooseParkingLotByLeftPositions();
    }
}
