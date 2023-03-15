package parking.lot.entity.directors;

import lombok.Getter;
import lombok.Setter;

import io.vavr.collection.List;
import parking.lot.entity.valets.ParkingTable;
import parking.lot.entity.valets.Valet;

@Getter
@Setter
public class ParkingDirector {
    private ParkingTable parkingTable;

    public ParkingDirector(List<Valet> subordinates) {
        this.parkingTable = new ParkingTable(subordinates);
    }
}
