package parking.lot.entity.valets.decorators;

import io.vavr.collection.List;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.valets.Valet;

public class FirstEmptyFitDecorator extends FitDecorator {
    public FirstEmptyFitDecorator(Valet valet) {
        super(valet);
    }

    @Override
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots){
        ParkingLot parkingLot = parkingLots.get(0);
        for (ParkingLot currenParkinglot : parkingLots) {
            if(currenParkinglot.hasSpace()){
                parkingLot = currenParkinglot;
            }
        }
        return parkingLot;
    }
}
