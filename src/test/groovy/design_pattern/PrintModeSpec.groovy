package design_pattern

import parking.lot.entity.recordModes.SimplifiedPrint
import parking.lot.entity.valets.BasicValet
import parking.lot.entity.vehicles.Car
import spock.lang.Specification

class PrintModeSpec extends Specification {
     def "should print simplified info" (){
        given:
        def valet = new BasicValet()
        def vehicle = new Car("c000000")
        def simplifiedPrint = new SimplifiedPrint()
        when:
        valet.setPrintMode(simplifiedPrint)
        then:
        valet.printParkingResult(vehicle) == "park successful: one car"
    }
}
