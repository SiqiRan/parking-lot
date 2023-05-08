package design_pattern

import parking.lot.entity.valets.ParkingBoy
import parking.lot.entity.valets.ParkingManager
import parking.lot.entity.valets.ValetFactory
import spock.lang.Specification

class BasicValetFactorySpec extends Specification {
    def "should generate valets" (){
        given:
        def valetFactory = ValetFactory.getValetFactory()
        when:
        def result = valetFactory.generateValet("boy")
        then:
        result.getClass() == ParkingBoy.class
    }

    def "should initialize the fields in valets" (){
        given:
        def valetFactory = ValetFactory.getValetFactory()
        when:
        def result= valetFactory.generateValet("manager")
        result  = result as ParkingManager
        then:
        result.class == ParkingManager.class
        result.getSubordinates().length() == 0
    }

}

