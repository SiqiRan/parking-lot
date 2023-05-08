package design_pattern

import io.vavr.collection.List
import parking.lot.entity.parking.ParkingLot
import parking.lot.entity.valets.BasicValet
import parking.lot.entity.valets.decorators.FirstEmptyFitDecorator
import parking.lot.entity.vehicles.Car
import spock.lang.Specification

class FitDecoratorSpec extends Specification {
    def "should use First Empty Fit Decorator"(){
        given:
        def valet = new BasicValet()
        valet = new FirstEmptyFitDecorator(valet)
        def parkingLotOne = new ParkingLot(1L, List.of(new Car("p000000")),"one")
        def parkingLotTwo = new ParkingLot(1L,List.empty(),"two")
        valet.addParkingLot(parkingLotOne)
        valet.addParkingLot(parkingLotTwo)

        when:
        ParkingLot parkingLot = valet.chooseParkingLot(valet.parkingLots)
        valet.parkToParkingLot(new Car("p000001"),parkingLot)

        then:
        valet.getParkingLots().get(1).getVehicles().get(0).getPlateNumber() == "p000001"
    }

}
