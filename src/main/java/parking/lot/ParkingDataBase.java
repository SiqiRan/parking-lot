package parking.lot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.operators.*;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
@Getter
@Setter
public class ParkingDataBase {
    private static @Getter  ParkingDataBase instance = new ParkingDataBase();
    private static List<Valet> staff;
    private static ParkingBoy parkingBoy;
    private static SmartParkingBoy smartParkingBoy;
    private static ParkingManager parkingManager;
    private static ParkingDirector parkingDirector;

    private ParkingDataBase(){
        staff = new ArrayList<>();
        ParkingLot smallParkingLot = new ParkingLot(10L,new ArrayList<>(),"small parking lot");
        ParkingLot smallParkingLot2 = new ParkingLot(10L,new ArrayList<>(),"small parking lot 2");
        ParkingLot smallParkingLot3 = new ParkingLot(10L,new ArrayList<>(),"small parking lot 3");
        ParkingLot mediumParkingLot = new ParkingLot(20L,new ArrayList<>(),"medium parking lot");
        ParkingLot mediumParkingLot2 = new ParkingLot(20L,new ArrayList<>(),"medium parking lot 2");
        ParkingLot bigParkingLot = new ParkingLot(30L,new ArrayList<>(),"big parking lot");
        ParkingBoy parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(List.of(smallParkingLot2,mediumParkingLot));
        ParkingManager parkingManager = new ParkingManager(List.of(smallParkingLot3,mediumParkingLot2,bigParkingLot)
        ,List.of(parkingBoy,smartParkingBoy));
        ParkingDirector parkingDirector = new ParkingDirector(List.of(parkingBoy,smartParkingBoy,parkingManager));
    }

    public Car park(Car car){
        return parkingManager.parkCar(car);
    }
}
