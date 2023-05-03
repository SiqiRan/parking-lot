package parking.lot.entity.valets;

public class ValetFactory {

    Valet generateValet(String type){
        switch (type){
            case "smart":
                return new SmartParkingBoy();
            case "super":
                return new SuperParkingBoy();
            case "manager":
                return new ParkingManager();
            default:
                return new ParkingBoy();
        }

    }
}
