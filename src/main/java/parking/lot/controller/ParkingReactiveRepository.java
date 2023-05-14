package parking.lot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import parking.lot.entity.vehicles.Vehicle;
import reactor.core.publisher.Mono;

@Repository
public class ParkingReactiveRepository {

    WebClient webClient;
    String baseUrl;
    public ParkingReactiveRepository( @Value("${environment.dev.baseUrl}") String baseUrl) {
        this.baseUrl = baseUrl;
        this.webClient = WebClient.create(baseUrl);
    }

    public Mono<Vehicle> getVehicleById(Long carId){
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/"+carId).build())
                .retrieve()
                .bodyToMono(Vehicle.class);
    }

    public Mono<Vehicle> park(Vehicle vehicle) {
        return webClient
                .post()
                .bodyValue(vehicle)
                .retrieve()
                .bodyToMono(Vehicle.class);
    }
}
