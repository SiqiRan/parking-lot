package design_pattern

import parking.lot.entity.Customer
import parking.lot.entity.parking.DigitalParking
import parking.lot.entity.parking.FlatParking
import parking.lot.entity.parking.ManualParking
import parking.lot.entity.parking.Parking
import parking.lot.entity.parking.ParkingMQAdapter
import spock.lang.Specification

class VehicleMQAdapterSpec extends Specification {
    def manualParking = new ManualParking()
    def digitalParking = new DigitalParking()

    def "should convert to Parking Using ParkingMQAdapter"(){
        given:
        this.manualParking.setWhatKindOfCar("car")
        this.manualParking.setWhoseCar("Sponge Bob")
        this.manualParking.setId("AS9527")
        this.manualParking.setParkingTime("2023-05-05")

        this.digitalParking.setVehicleType("van")
        this.digitalParking.setOwner(new Customer("patrick","Next To The Pineapple"))
        this.digitalParking.setSerialNumber("number123")
        this.digitalParking.setParkingTime("2023-05-05")

        def manualParkingLink = new HashMap<String,String>()
        manualParkingLink.put("vehicleType","whatKindOfCar")
        manualParkingLink.put("customerName","whoseCar")
        manualParkingLink.put("plateNumber","id")

        def digitalParkingLink = new HashMap<String,String>()
        digitalParkingLink.put("plateNumber","serialNumber")
        digitalParkingLink.put("vehicleType","vehicleType")
        digitalParkingLink.put("customerName","name")
        digitalParkingLink.put("customerIdentification","identification")
        digitalParkingLink.put("parkingTime","parkingTime")

        when:
        def parkingMQAdapter = new ParkingMQAdapter<FlatParking>()

        def manualFlatParking = parkingMQAdapter.filter(this.manualParking.toString(),manualParkingLink, FlatParking.class)
        manualFlatParking = manualFlatParking as FlatParking
        def manualParkingResult = manualFlatParking.toParking()
        manualParkingResult = manualParkingResult as Parking


        def digitalFlatParking = parkingMQAdapter.filter(digitalParking.toString(),digitalParkingLink,FlatParking.class)
        digitalFlatParking = digitalFlatParking as FlatParking
        def digitalParkingResult = digitalFlatParking.toParking()
        digitalParkingResult = digitalParkingResult as Parking

        then:
        manualParkingResult.getOwner().getName() == "Sponge Bob"
        manualParkingResult.getVehicle().getPlateNumber() == "AS9527"
        manualParkingResult.getVehicle().getType() == "car"

        digitalParkingResult.getVehicle().getType() == "van"
    }
}
