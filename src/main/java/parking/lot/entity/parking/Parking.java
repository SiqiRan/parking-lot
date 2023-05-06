package parking.lot.entity.parking;

import parking.lot.entity.Customer;

import java.time.Instant;

public class Parking {
    private Long id;
    private String plateNumber;
    private Customer owner;
    private Instant parkingTime;
    private double parkingFee;

    public Parking(String plateNumber, Customer owner, Instant parkingTime) {
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.parkingTime = parkingTime;
        this.parkingFee = 0;
    }

    public Parking(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Instant getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(Instant parkingTime) {
        this.parkingTime = parkingTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
}
