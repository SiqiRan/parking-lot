package parking.lot.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parking.lot.controller.ParkingReactiveRepository;
import parking.lot.entity.vehicles.Car;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

class APIControllerTest {

    public static MockWebServer mockBackEnd;

    ParkingReactiveRepository parkingReactiveRepository;
    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s",
                mockBackEnd.getPort());
        parkingReactiveRepository = new ParkingReactiveRepository(baseUrl);
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }
    @Test
    void shouldPickUpACarWhenGivenCorrectId() throws JsonProcessingException {
        Car mockCar = new Car("1");
        ObjectMapper objectMapper = new ObjectMapper();
        mockBackEnd.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(mockCar))
                .addHeader("Content-Type", "application/json"));

        Mono<Car> carMono = parkingReactiveRepository.getCarById(2L);

        StepVerifier.create(carMono)
                .expectNextMatches(car -> car.getType()
                        .equals("car"))
                .verifyComplete();
    }

    @Test
    void shouldParkCarWhenGivenEnoughPositions() throws JsonProcessingException {
        Car mockCar = new Car("1");
        ObjectMapper objectMapper = new ObjectMapper();
        mockBackEnd.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(mockCar))
                .addHeader("Content-Type", "application/json"));

        Mono<Car> carMono = parkingReactiveRepository.parkCar(mockCar);

        StepVerifier.create(carMono)
                .expectNextMatches(car -> car.getType()
                        .equals("car"))
                .verifyComplete();
    }
}
