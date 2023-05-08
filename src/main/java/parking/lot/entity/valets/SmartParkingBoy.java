package parking.lot.entity.valets;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.parking.ParkingLot;

@Getter
@Setter
public class SmartParkingBoy extends BasicValet {

    public SmartParkingBoy() {
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        return chooseParkingLotByLeftPositions();
    }
}
