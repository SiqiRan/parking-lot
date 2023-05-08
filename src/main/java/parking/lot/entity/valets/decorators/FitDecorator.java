package parking.lot.entity.valets.decorators;

import io.vavr.collection.List;
import io.vavr.control.Option;
import parking.lot.entity.parking.ParkingLot;
import parking.lot.entity.valets.Valet;
import parking.lot.entity.vehicles.Vehicle;

public abstract class FitDecorator implements Valet {
    private final Valet valet;

    public FitDecorator(Valet valet){
        this.valet = valet;
    }

    @Override
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots) {
        return valet.chooseParkingLot(parkingLots);
    }

    @Override
    public Option<Vehicle> park(Vehicle vehicle) {
        return valet.park(vehicle);
    }

    @Override
    public Option<Vehicle> pickUp(String plateNumber) {
        return valet.pickUp(plateNumber);
    }


}
