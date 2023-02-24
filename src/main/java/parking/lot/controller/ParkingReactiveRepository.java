package parking.lot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import parking.lot.entity.Car;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ParkingReactiveRepository {

    WebClient webClient;
    String baseUrl;
    public ParkingReactiveRepository(String baseUrl) {
        this.baseUrl = baseUrl;
        this.webClient = WebClient.create(baseUrl);
    }

    public Mono<Car> getCarById(Long carId){
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/"+carId).build())
                .retrieve()
                .bodyToMono(Car.class);
    }

    public Mono<Car> parkCar(Car car) {
        return webClient
                .post()
                .bodyValue(car)
                .retrieve()
                .bodyToMono(Car.class);
    }
}
