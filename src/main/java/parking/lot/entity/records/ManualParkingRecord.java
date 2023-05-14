package parking.lot.entity.records;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is to simulate parking recorded in handwriting.
 */
public class ManualParkingRecord {
    ObjectMapper objectMapper = new ObjectMapper();
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
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
