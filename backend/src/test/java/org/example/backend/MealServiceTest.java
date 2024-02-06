package org.example.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.backend.entity.MealCategory;
import org.example.backend.entity.MealRecord;
import org.example.backend.exception.ErrorMessage;
import org.example.backend.exception.NotFoundException;
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

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void getMealsByNameNotFound_getMealsByCategoryNotFound(){
        //GIVEN
        MealRecord mealRecord = new MealRecord(
                "658300534635ad5e48abb8b8",
                "52837",
                "Pilchard puttanesca",
                "Pasta",
                "Italian",
                "Cook the pasta following pack instructions. Heat the oil in a non-stick frying pan and cook the onion, garlic and chilli for 3-4 mins to soften. Stir in the tomato purée and cook for 1 min, then add the pilchards with their sauce. Cook, breaking up the fish with a wooden spoon, then add the olives and continue to cook for a few more mins.\r\n\r\nDrain the pasta and add to the pan with 2-3 tbsp of the cooking water. Toss everything together well, then divide between plates and serve, scattered with Parmesan.",
                "https://www.themealdb.com/images/media/meals/vvtvtr1511180578.jpg",
                "",
                "Spaghetti",
                "Olive Oil",
                "Onion",
                "Garlic",
                "Red Chilli",
                "Tomato Puree",
                "Pilchards",
                "Black Olives",
                "Parmesan",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "300g",
                "1 tbls",
                "1 finely chopped ",
                "2 cloves minced",
                "1",
                "1 tbls",
                "425g",
                "70g",
                "Shaved",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );
        List<MealRecord> expected = List.of(mealRecord);
        when(mockMealRepo.findAllByStrMealContainingIgnoreCase("Pilchard puttanesca")).thenReturn(expected);
        MealService mealService = new MealService(mockMealRepo, mockMealCategoryRepo, mockIdService);

        //WHEN
        try{
            List<MealRecord> actual = mealService.getMealsByName("Test");
            //THEN
            assertTrue(actual.isEmpty());
        } catch (NotFoundException e) {
            assertEquals("There isn't any meal with name: Test", e.getMessage());
        }

        //WHEN
        try{
            List<MealRecord> actual = mealService.getMealsByCategory("Beef");
            //THEN
            assertTrue(actual.isEmpty());
        } catch (NotFoundException e) {
            assertEquals("The category you are searching for is not existing.", e.getMessage());
        }
    }
}
