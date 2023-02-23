package parking.lot.operators;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import parking.lot.entity.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

class FluxTest {
    @Test
    void shouldGenerateAFlux(){
        Flux<Car> fluxCar = WebClient.builder()
                .baseUrl("http://localhost:3002/parkinglot")
                .build()
                .get()
                .retrieve()
                .bodyToFlux(Car.class);
        fluxCar.collectList().block().stream().forEach(System.out::println);
    }
}
