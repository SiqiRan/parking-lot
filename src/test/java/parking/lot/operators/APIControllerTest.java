package parking.lot.operators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import parking.lot.entity.Car;

class APIControllerTest extends WebApplicationTest{
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void shouldPickUpACarWhenGivenCorrectId() {
       webTestClient
               .get()
               .uri("http://localhost:8080/parkingLot/1")
               .accept(MediaType.APPLICATION_JSON)
               .exchange()
               .expectStatus().isOk()
               .expectBody().json("{\n" +
                       "      \"id\": 1,\n" +
                       "      \"ownerId\": 1\n" +
                       "    }");
    }

    @Test
    void shouldParkACarWhenGivenEnoughEmptyPositions() throws Exception {
        Car car = new Car(6L,"van",6L);
        webTestClient
                .post()
                .uri("http://localhost:8080/parkingLot")
                .bodyValue(car)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isCreated()
                .expectBody().jsonPath("$.carName").isEqualTo("van");
    }
}
