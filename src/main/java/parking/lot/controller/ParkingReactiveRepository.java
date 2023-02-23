package parking.lot.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import parking.lot.entity.Car;
import reactor.core.publisher.Mono;

@Repository
public class ParkingReactiveRepository {

    public Mono<Car> getCarById(Long carId){
        return WebClient.builder()
                .baseUrl("http://localhost:3002/parkinglot/" + carId)
                .build()
                .get()
                .retrieve()
                .bodyToMono(Car.class);
    }
}
