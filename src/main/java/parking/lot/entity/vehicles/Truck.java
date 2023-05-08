package parking.lot.entity.vehicles;

public class Truck extends Vehicle {

    private Double TruckLoad;

    public Truck(String plateNumber) {
        super("truck", plateNumber);
    }

    public Truck() {
    }
}
