package parking.lot.entity.valets;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.parking.ParkingLot;

@Getter
@Setter
public class ParkingTable {
    private List<ParkingLot> parkingLots;
    private List<BasicValet> valets;

    public ParkingTable(List<BasicValet> valets){
        this.valets = valets;
        this.parkingLots = List.empty();
        for (BasicValet basicValet : valets) {
            parkingLots = parkingLots.appendAll(basicValet.getParkingLots());
        }
    }

}
