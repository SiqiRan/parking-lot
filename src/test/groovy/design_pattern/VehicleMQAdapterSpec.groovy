package design_pattern

import parking.lot.entity.parking.FlatParking
import parking.lot.entity.parking.ManualParking
import parking.lot.entity.parking.ParkingMQAdapter
import spock.lang.Specification

class VehicleMQAdapterSpec extends Specification {
    def manualParking = new ManualParking()

    def "should convert to Parking Using ParkingMQAdapter"(){
        given:
        manualParking.setWhatKindOfCar("car")
        manualParking.setWhoseCar("Sponge Bob")
        manualParking.setId("AS9527")
        manualParking.setParkingTime("2023-05-05")

        def manualParkingLink = new HashMap<String,String>()
        manualParkingLink.put("carType","whatKindOfCar")
        manualParkingLink.put("customerName","whoseCar")
        manualParkingLink.put("plateNumber","id")

        when:
        def parkingMQAdapter = new ParkingMQAdapter<FlatParking>()
        def flatParking = parkingMQAdapter.filter(manualParking.toString(),manualParkingLink, FlatParking.class)
        flatParking = flatParking as FlatParking
        def result = flatParking.toParking()

        then:
        result.getOwner().getName() == "Sponge Bob"
        result.getPlateNumber() == "AS9527"

    }
}
