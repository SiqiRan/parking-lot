package parking.lot.entity.valets.decorators;

import io.vavr.collection.List;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.valets.Valet;

public class MostAvailablePositionsFitDecorator extends FitDecorator {

    public MostAvailablePositionsFitDecorator(Valet valet) {
        super(valet);
    }

    @Override
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot mostEmptyPositions = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getEmptyPositions() > mostEmptyPositions.getEmptyPositions()){
                mostEmptyPositions = parkingLot;
            }
        }
        return mostEmptyPositions;
    }

}
