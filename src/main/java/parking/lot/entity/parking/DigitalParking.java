package parking.lot.entity.parking;

import com.alibaba.fastjson.JSON;
import parking.lot.entity.Customer;

public class DigitalParking {
    private Customer owner;
    private String carType;
    private String id;
    private String parkingTime;

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(String parkingTime) {
        this.parkingTime = parkingTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
