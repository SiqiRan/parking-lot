package parking.lot.entity.valets;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.parking.ParkingLot;

@Getter
@Setter
public class ParkingTable {
    private List<ParkingLot> parkingLots;
    private List<Valet> valets;

    public ParkingTable(List<Valet> valets){
        this.valets = valets;
        this.parkingLots = List.empty();
        for (Valet valet : valets) {
            parkingLots = parkingLots.appendAll(valet.getParkingLots());
        }
    }

}
