package parking.lot.entity.parking;

import parking.lot.entity.Customer;
import parking.lot.entity.vehicles.Vehicle;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Parking {
    private Long id;
    private Vehicle vehicle;
    private Customer owner;
    private Instant parkingTime;
    private double parkingFee;

    public Parking(Vehicle vehicle, Customer owner, Instant parkingTime) {
        this.vehicle = vehicle;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public void setParkingTime(String parkingTime) {
        LocalDate localDate = LocalDate.parse(parkingTime);
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        this.parkingTime = zonedDateTime.toInstant();
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
}
