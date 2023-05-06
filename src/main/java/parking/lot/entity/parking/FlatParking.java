package parking.lot.entity.parking;

import parking.lot.entity.Customer;
import parking.lot.entity.vehicles.Vehicle;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FlatParking {
    private Long id;
    private String vehicleType;
    private String plateNumber;
    private String customerName;
    private String customerIdentification;
    private Instant parkingTime;
    private double parkingFee;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIdentification() {
        return customerIdentification;
    }

    public void setCustomerIdentification(String customerIdentification) {
        this.customerIdentification = customerIdentification;
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Parking toParking(){
        return new Parking(new Vehicle(this.vehicleType,this.plateNumber), new Customer(this.customerName,this.customerIdentification),this.parkingTime);
    }
}
