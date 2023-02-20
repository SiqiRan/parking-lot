package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.ParkingLot;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParkingTable {
    private List<ParkingLot> parkingLots;
    private List<Valet> valets;

    public ParkingTable(List<Valet> valets){
        this.parkingLots = new ArrayList<>();
        for (Valet valet : valets) {
            parkingLots.addAll(valet.getParkingLots());
        }
    }

}
