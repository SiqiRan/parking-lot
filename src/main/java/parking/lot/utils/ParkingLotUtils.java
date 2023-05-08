package parking.lot.utils;

import io.vavr.collection.List;
import parking.lot.entity.parking.ParkingLot;

public class ParkingLotUtils {
    private ParkingLotUtils(){}

    public static boolean checkIfAvailable(List<ParkingLot> parkingLots){
       for(ParkingLot parkingLot: parkingLots){
           if (parkingLot.getEmptyPositions() == 0){
               return false;
           }
       }
       return true;
    }
}
