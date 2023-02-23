package parking.lot.operators;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import parking.lot.entity.Car;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class APIControllerTest extends WebApplicationTest{
//    @Autowired
//    private MockMvc mockMvc;
//    @Test
//    void shouldPickUpACarWhenGivenEnoughEmptyPositions() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/parkingLot/1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
//    }
//
//    @Test
//    void shouldParkACarWhenGivenEnoughEmptyPositions() throws Exception {
//        Car car = new Car(2L,2L);
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/parkingLot")
//                        .content(new ObjectMapper().writeValueAsString(car))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                )
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2));
//    }
}
