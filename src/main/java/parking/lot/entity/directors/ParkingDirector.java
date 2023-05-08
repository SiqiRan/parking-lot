package parking.lot.entity.directors;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.valets.ParkingTable;
import parking.lot.entity.valets.Valet;
import parking.lot.entity.valets.ValetFactory;

@Getter
@Setter
public class ParkingDirector {
    private ParkingTable parkingTable;

    private ValetFactory valetFactory;

    public ParkingDirector(List<Valet> subordinates) {
        this.parkingTable = new ParkingTable(subordinates);
    }

    public Valet createValet(String type){
        return valetFactory.generateValet(type);
    }

}
