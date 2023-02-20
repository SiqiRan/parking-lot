package parking.lot.operators;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingDirector {
    private List<Valet> subordinates;
    private ParkingTable parkingTable;


    public ParkingDirector(List<Valet> subordinates) {
        this.subordinates = subordinates;
        this.parkingTable = new ParkingTable(this.subordinates);
    }
}
