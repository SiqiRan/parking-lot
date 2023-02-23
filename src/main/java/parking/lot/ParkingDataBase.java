package parking.lot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import parking.lot.entity.Car;
import parking.lot.entity.ParkingLot;
import parking.lot.exceptions.FullyOccupiedException;
import parking.lot.operators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope("singleton")
@Getter
@Setter
public class ParkingDataBase {
    private static @Getter  ParkingDataBase instance = new ParkingDataBase();
    private  List<Valet> staff;
    private  ParkingBoy parkingBoy;
    private  SmartParkingBoy smartParkingBoy;
    private  ParkingManager parkingManager;
    private  ParkingDirector parkingDirector;

    private ParkingDataBase(){
        staff = new ArrayList<>();
        ParkingLot smallParkingLot = new ParkingLot(10L,new ArrayList<>(List.of(new Car(1L,1L))),"small parking lot");
        ParkingLot smallParkingLot2 = new ParkingLot(10L,new ArrayList<>(),"small parking lot 2");
        ParkingLot smallParkingLot3 = new ParkingLot(10L,new ArrayList<>(),"small parking lot 3");
        ParkingLot mediumParkingLot = new ParkingLot(20L,new ArrayList<>(),"medium parking lot");
        ParkingLot mediumParkingLot2 = new ParkingLot(20L,new ArrayList<>(),"medium parking lot 2");
        ParkingLot bigParkingLot = new ParkingLot(30L,new ArrayList<>(),"big parking lot");
        parkingBoy = new ParkingBoy(List.of(smallParkingLot));
        smartParkingBoy = new SmartParkingBoy(List.of(smallParkingLot2,mediumParkingLot));
        parkingManager = new ParkingManager(List.of(smallParkingLot3,mediumParkingLot2,bigParkingLot)
        ,List.of(parkingBoy,smartParkingBoy));
        parkingDirector = new ParkingDirector(List.of(parkingBoy,smartParkingBoy,parkingManager));
        staff.addAll(List.of(parkingBoy,smartParkingBoy,parkingManager));
    }

    public Car park(Car car){
        Optional<Car> parking = parkingManager.parkCar(car);
        if(parking.isPresent()){
            return parking.get();
        }
        throw new FullyOccupiedException("Sorry, no available position now!");
    }

    public Car pickUp(long carId){
        return parkingManager.pickUpWithSubordinates(carId);
    }
}
