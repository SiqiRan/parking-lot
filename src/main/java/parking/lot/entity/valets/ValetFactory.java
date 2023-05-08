package parking.lot.entity.valets;

public class ValetFactory {

    private static ValetFactory instance;

    private ValetFactory(){

    }

    public static ValetFactory getValetFactory(){
        if(instance == null){
            instance = new ValetFactory();
        }
        return instance;
    }

    public BasicValet generateValet(String type){
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
