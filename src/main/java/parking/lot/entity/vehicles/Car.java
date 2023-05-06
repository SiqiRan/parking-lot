package parking.lot.entity.vehicles;

public class Car extends Vehicle {

    public Double engineDisplacement;
    public Car(String plateNumber) {
        super("car", plateNumber);
    }

    private Car(String type, String plateNumber) {
        super(type, plateNumber);
    }

    public Car() {
        super();
    }
}
