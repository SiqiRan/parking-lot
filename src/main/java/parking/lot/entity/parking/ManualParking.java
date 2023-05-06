package parking.lot.entity.parking;

import com.alibaba.fastjson.JSON;

/**
 * This is to simulate parking recorded in handwriting.
 */
public class ManualParking {

    private String whatKindOfCar;
    private String id;
    private String whoseCar;
    private String parkingTime;

    public String getWhatKindOfCar() {
        return whatKindOfCar;
    }

    public void setWhatKindOfCar(String whatKindOfCar) {
        this.whatKindOfCar = whatKindOfCar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWhoseCar() {
        return whoseCar;
    }

    public void setWhoseCar(String whoseCar) {
        this.whoseCar = whoseCar;
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
