
package org.example.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class MealControllerTest {
    private final String BASE_URL = "/api/meals";
    @Autowired
    private MockMvc mvc;
    @Autowired
    private MealController mealController;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getAllMeals_shouldReturnEmptyList_WhenCalledInitially() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get(BASE_URL)
                )
                .andExpect(
                        status()
                                .isOk()
                )
                .andExpect(
                        content()
                                .json("[]")
                );
    }

    @Test
    void shouldReturnMeal_whenStoredInDb() throws Exception {
        MealDto meal = new MealDto(
                //"658300534635ad5e48abb8b8",
                // "52837",
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
        //GIVEN
        String bodyJson = objectMapper.writeValueAsString(meal);

        MvcResult result = mvc.perform(post(BASE_URL + "/add")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(bodyJson))
                .andReturn();

        MealRecord mealInDB = objectMapper.readValue(result.getResponse().getContentAsString(Charset.forName("UTF-8")), MealRecord.class);
        String mealAsJson = objectMapper.writeValueAsString(mealInDB);
        System.out.println("body: "+result.getResponse().getContentAsString());


        //WHEN
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + mealInDB._id()))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json(mealAsJson));

        //WHEN
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/category/" + mealInDB.strCategory()))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(List.of(mealAsJson))));

        //WHEN
        mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/letter/" + mealInDB.strMeal().charAt(0)))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(List.of(mealAsJson))));

        // update meal
        // GIVEN
        MealRecord updateMeal = new MealRecord(
                mealInDB._id(),
                mealInDB.idMeal(),
                "Test",
                "Pasta",
                "Italian",
                "Test",
                "",
                "",
                "t1",
                "t2",
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
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "t3",
                "t4",
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
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );
        // WHEN
        String updatedMealAsJSON = objectMapper.writeValueAsString(updateMeal);
        // THEN
        mvc.perform(put(BASE_URL + "/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(updatedMealAsJSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(updatedMealAsJSON));
    }

}