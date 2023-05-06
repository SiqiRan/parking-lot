package parking.lot.entity.parking;

import parking.lot.entity.Customer;

import java.time.Instant;

public class FlatParking {
    private Long id;
    private String carType;
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

    public void setParkingTime(Instant parkingTime) {
        this.parkingTime = parkingTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Parking toParking(){
        return new Parking(this.plateNumber, new Customer(this.customerName,this.customerIdentification),this.parkingTime);
    }
}
