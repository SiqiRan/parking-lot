package parking.lot.entity.vehicles;

public class Vehicle {

    String type;
    String plateNumber;

    public Vehicle(String type, String plateNumber) {
        this.type = type;
        this.plateNumber = plateNumber;
    }

    public Vehicle() {

    }

    @Override
    public String toString() {
        return String.format("It's a(an) %s, the plate number is %s",type,plateNumber);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
