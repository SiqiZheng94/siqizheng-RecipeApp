package org.example.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MealServiceTest {
    ErrorMessage errorMessage;

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;
    // mock the TimestampService to return a fixed timestamp in the test
    @MockBean
    private TimestampService timestampService;

    @Test
    void errorMessage() throws JsonProcessingException {
        TimestampService timestampService = mock(TimestampService.class);
        LocalDateTime fixedTimestamp = LocalDateTime.of(2024,1,1,0,0,0,0);
        when(timestampService.getTime()).thenReturn(fixedTimestamp);


        ErrorMessage actual=new ErrorMessage("Meal with ID:1 isn't found.", timestampService.getTime());
        String actualJson = objectMapper.writeValueAsString(actual);
        String exceptedJson = """
                {"message":"Meal with ID:1 isn't found.","timestamp":"2024-01-01T00:00:00"}""";

        verify(timestampService).getTime();
        assertEquals(actualJson,exceptedJson);
    }
}
