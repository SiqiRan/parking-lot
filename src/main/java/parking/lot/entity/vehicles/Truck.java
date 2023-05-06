package parking.lot.entity.vehicles;

public class Truck extends Vehicle {

    public Double TruckLoad;
    public Truck(String type, String plateNumber) {
        super(type, plateNumber);
    }

    private Truck(String plateNumber){
        super();
    }

    public Truck() {
    }
}
