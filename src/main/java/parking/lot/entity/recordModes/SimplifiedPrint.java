package parking.lot.entity.recordModes;

import parking.lot.entity.vehicles.Vehicle;

public class SimplifiedPrint implements PrintMode {
    @Override
    public String printParking(Vehicle vehicle) {
        return "park successful: one " + vehicle.getType();
    }
}
