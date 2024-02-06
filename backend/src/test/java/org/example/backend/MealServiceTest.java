package org.example.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.backend.entity.MealCategory;
import org.example.backend.exception.ErrorMessage;
import org.example.backend.repo.MealCategoryRepo;
import org.example.backend.repo.MealRepo;
import org.example.backend.service.IdService;
import org.example.backend.service.MealService;
import org.example.backend.service.TimestampService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest

class MealServiceTest {
    ErrorMessage errorMessage;
    private final MealCategoryRepo mockMealCategoryRepo=mock(MealCategoryRepo.class);
    private final MealRepo mockMealRepo=mock(MealRepo.class);
    private final IdService mockIdService=mock(IdService.class);
    @Autowired
    ObjectMapper objectMapper;
    // mock the TimestampService to return a fixed timestamp in the test

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

    @Test
    void getAllCategories(){
        //GIVEN
        MealCategory mealCategory = new MealCategory("1", "1", "Beef", "test");
        List<MealCategory> expected = List.of(mealCategory);
        when(mockMealCategoryRepo.findAll()).thenReturn(expected);
        MealService mealService = new MealService(mockMealRepo, mockMealCategoryRepo, mockIdService);
        //WHEN
        List<MealCategory> actual = mealService.getAllCategories();
        //THEN
        verify(mockMealCategoryRepo).findAll();
        assertEquals(expected, actual);
    }
}
