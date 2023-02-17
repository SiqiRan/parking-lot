package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.Car;
import parking.lot.ParkingLot;
import parking.lot.exceptions.CarNotFoundException;

import java.util.List;

@Getter
@Setter
public class ParkingManager extends Valet implements Operator {
    List<Valet> employees;

    public ParkingManager(List<ParkingLot> parkingLots,List<Valet> employees) {
        super(parkingLots);
        this.employees = employees;
    }

    @Override
    public Car pickUp(Long carId) throws CarNotFoundException {
        return null;
    }

    @Override
    public ParkingLot chooseParkingLot() {
        return this.getParkingLots().get(0);
    }

    public void assignPark(Car carToAssignToPark) {
        Valet employee = this.employees.get(0);
        employee.parkCar(carToAssignToPark);
    }
}
