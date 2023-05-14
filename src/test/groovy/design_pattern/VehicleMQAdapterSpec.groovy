package design_pattern

import parking.lot.entity.Customer
import parking.lot.entity.records.DigitalParkingRecord
import parking.lot.entity.records.FlatParkingRecord
import parking.lot.entity.records.ManualParkingRecord
import parking.lot.entity.records.ParkingAdapter
import parking.lot.entity.records.ParkingRecord
import parking.lot.entity.records.SmartParkingRecord
import parking.lot.entity.vehicles.Truck
import spock.lang.Specification

class VehicleMQAdapterSpec extends Specification {
    def manualParkingMessage = new ManualParkingRecord()
    def digitalParkingMessage = new DigitalParkingRecord()
    def smartParkingMessage = new SmartParkingRecord()

    def "should convert to Parking Using ParkingMQAdapter"(){
        given:

        //============================= set up the input messages =============================//

        this.manualParkingMessage.setWhatKindOfCar("car")
        this.manualParkingMessage.setWhoseCar("Sponge Bob")
        this.manualParkingMessage.setId("AS9527")
        this.manualParkingMessage.setParkingTime("2023-05-05")

        this.digitalParkingMessage.setVehicleType("van")
        this.digitalParkingMessage.setOwner(new Customer("patrick","i000000"))
        this.digitalParkingMessage.setSerialNumber("x000000")
        this.digitalParkingMessage.setParkingTime("2023-05-05")

        this.smartParkingMessage.setVehicle(new Truck("x000001"))
        this.smartParkingMessage.setCustomer(new Customer("squid ward","i000001"))
        this.smartParkingMessage.setParkingTime("2023-05-05")

        //============================= set up the links =============================//

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

        def smartParkingLink = new HashMap<String,String>()
        smartParkingLink.put("plateNumber","plateNumber")
        smartParkingLink.put("vehicleType","type")
        smartParkingLink.put("customerName","name")
        smartParkingLink.put("customerIdentification","identification")
        smartParkingLink.put("parkingTime","parkingTime")

        when:
        def parkingMQAdapter = new ParkingAdapter<FlatParkingRecord>()

        def manualFlatParking = parkingMQAdapter.filter(this.manualParkingMessage.toString(),manualParkingLink, FlatParkingRecord.class)
        manualFlatParking = manualFlatParking as FlatParkingRecord
        def manualParkingResult = manualFlatParking.toParking()
        manualParkingResult = manualParkingResult as ParkingRecord

        def digitalFlatParking = parkingMQAdapter.filter(digitalParkingMessage.toString(),digitalParkingLink,FlatParkingRecord.class)
        digitalFlatParking = digitalFlatParking as FlatParkingRecord
        def digitalParkingResult = digitalFlatParking.toParking()
        digitalParkingResult = digitalParkingResult as ParkingRecord

        def smartFlatParking  = parkingMQAdapter.filter(smartParkingMessage.toString(),smartParkingLink,FlatParkingRecord.class)
        smartFlatParking = smartFlatParking as FlatParkingRecord
        def smartParkingResult = smartFlatParking.toParking()
        smartParkingResult = smartParkingResult as ParkingRecord

        then:
        manualParkingResult.getOwner().getName() == "Sponge Bob"
        manualParkingResult.getVehicle().getPlateNumber() == "AS9527"
        manualParkingResult.getVehicle().getType() == "car"

        digitalParkingResult.getOwner().getName() == "patrick"
        digitalParkingResult.getOwner().getIdentification() == "i000000"
        digitalParkingResult.getVehicle().getPlateNumber() == "x000000"
        digitalParkingResult.getVehicle().getType() == "van"

        smartParkingResult.getOwner().getName() == "squid ward"
        smartParkingResult.getOwner().getIdentification() == "i000001"
        smartParkingResult.getVehicle().getPlateNumber() == "x000001"
        smartParkingResult.getVehicle().getType() == "truck"
    }
}
