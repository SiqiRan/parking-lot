package parking.lot.entity.parking;

import com.alibaba.fastjson.JSON;
import parking.lot.entity.Customer;
import parking.lot.entity.vehicles.Vehicle;

import java.time.Instant;

public class SmartParking {
    Customer customer;
    Vehicle vehicle;
    Instant parkingTime;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Instant getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(Instant parkingTime) {
        this.parkingTime = parkingTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
