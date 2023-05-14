package parking.lot.entity.recordModes;

import parking.lot.entity.vehicles.Vehicle;

public class NormalPrint implements PrintMode {

    @Override
    public String printParking(Vehicle vehicle) {
        return "parking successful: " + vehicle.toString();
    }
}
