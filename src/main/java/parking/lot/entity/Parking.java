package parking.lot.entity;

import java.time.Instant;

public class Vehicle {
    Long id;
    Long plateNumber;
    String ownerId;
    String ownerName;
    Instant parkingTime;
    Long parkingFee;
}
