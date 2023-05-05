package parking.lot.entity;

public class Car extends Vehicle {

    public Car(String plateNumber) {
        super("car", plateNumber);
    }

    public Car(String type, String plateNumber) {
        super(type, plateNumber);
    }

    public Car() {
        super();
    }
}
