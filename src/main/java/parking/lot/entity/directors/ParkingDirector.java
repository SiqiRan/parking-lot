package parking.lot.entity.directors;

import io.vavr.collection.List;
import lombok.Getter;
import lombok.Setter;
import parking.lot.entity.valets.BasicValet;
import parking.lot.entity.valets.ParkingTable;
import parking.lot.entity.valets.ValetFactory;

@Getter
@Setter
public class ParkingDirector {
    private ParkingTable parkingTable;

    private ValetFactory valetFactory;

    public ParkingDirector(List<BasicValet> subordinates) {
        this.parkingTable = new ParkingTable(subordinates);
    }

    public BasicValet createValet(String type){
        return valetFactory.generateValet(type);
    }

}
