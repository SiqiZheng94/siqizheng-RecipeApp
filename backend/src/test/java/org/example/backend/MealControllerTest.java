/*
package org.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode= DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MealControllerTest {
    private final String BASE_URL="/api/meals";
    @Autowired
    private MockMvc mvc;
    @Autowired
    private MealController mealController;
    @Test
    void getAllMeals_shouldReturnEmptyList_WhenCalledInitially()throws Exception{
        mvc.perform(
                MockMvcRequestBuilders.get(BASE_URL)
                )
                .andExpect(
                        MockMvcResultMatchers.status()
                        .isOk()
                )
                .andExpect(
                        MockMvcResultMatchers.content()
                                .json("[]")
                        );
    }
@Test
    void shouldReturnMeal_whenStoredInDb() throws Exception{
        MealDto meal= new MealDto(
                "65798940147f2ee6720d3cae",
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
        mealController.addMeal(meal);
        mvc.perform(
                MockMvcRequestBuilders.get(BASE_URL)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                [
                    {
                        "_id": "65798940147f2ee6720d3cae",
                        "idMeal": "52837",
                        "strMeal": "Pilchard puttanesca",
                        "strCategory": "Pasta",
                        "strArea": "Italian",
                        "strInstructions": "Cook the pasta following pack instructions. Heat the oil in a non-stick frying pan and cook the onion, garlic and chilli for 3-4 mins to soften. Stir in the tomato purée and cook for 1 min, then add the pilchards with their sauce. Cook, breaking up the fish with a wooden spoon, then add the olives and continue to cook for a few more mins.\\r\\n\\r\\nDrain the pasta and add to the pan with 2-3 tbsp of the cooking water. Toss everything together well, then divide between plates and serve, scattered with Parmesan.",
                        "strMealThumb": "https://www.themealdb.com/images/media/meals/vvtvtr1511180578.jpg",
                        "strTags": "",
                        "strIngredient1": "Spaghetti",
                        "strIngredient2": "Olive Oil",
                        "strIngredient3": "Onion",
                        "strIngredient4": "Garlic",
                        "strIngredient5": "Red Chilli",
                        "strIngredient6": "Tomato Puree",
                        "strIngredient7": "Pilchards",
                        "strIngredient8": "Black Olives",
                        "strIngredient9": "Parmesan",
                        "strIngredient10": "",
                        "strIngredient11": "",
                        "strIngredient12": "",
                        "strIngredient13": "",
                        "strIngredient14": "",
                        "strIngredient15": "",
                        "strIngredient16": "",
                        "strIngredient17": "",
                        "strIngredient18": "",
                        "strIngredient19": "",
                        "strIngredient20": "",
                        "strMeasure1": "300g",
                        "strMeasure2": "1 tbls",
                        "strMeasure3": "1 finely chopped ",
                        "strMeasure4": "2 cloves minced",
                        "strMeasure5": "1",
                        "strMeasure6": "1 tbls",
                        "strMeasure7": "425g",
                        "strMeasure8": "70g",
                        "strMeasure9": "Shaved",
                        "strMeasure10": "",
                        "strMeasure11": "",
                        "strMeasure12": "",
                        "strMeasure13": "",
                        "strMeasure14": "",
                        "strMeasure15": "",
                        "strMeasure16": "",
                        "strMeasure17": "",
                        "strMeasure18": "",
                        "strMeasure19": "",
                        "strMeasure20": ""
                    }]
                    """
                ));
    }
    @Test
    void getMealsByCategory_shouldReturnMeal_whenCategoryIsPasta()throws Exception{
        MealDto meal= new MealDto(
                "65798940147f2ee6720d3cae",
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
        mealController.addMeal(meal);
        mvc.perform(
                MockMvcRequestBuilders.get(BASE_URL + "/category/Pasta")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """

[
                    {
                        "_id": "65798940147f2ee6720d3cae",
                        "idMeal": "52837",
                        "strMeal": "Pilchard puttanesca",
                        "strCategory": "Pasta",
                        "strArea": "Italian",
                        "strInstructions": "Cook the pasta following pack instructions. Heat the oil in a non-stick frying pan and cook the onion, garlic and chilli for 3-4 mins to soften. Stir in the tomato purée and cook for 1 min, then add the pilchards with their sauce. Cook, breaking up the fish with a wooden spoon, then add the olives and continue to cook for a few more mins.\\r\\n\\r\\nDrain the pasta and add to the pan with 2-3 tbsp of the cooking water. Toss everything together well, then divide between plates and serve, scattered with Parmesan.",
                        "strMealThumb": "https://www.themealdb.com/images/media/meals/vvtvtr1511180578.jpg",
                        "strTags": "",
                        "strIngredient1": "Spaghetti",
                        "strIngredient2": "Olive Oil",
                        "strIngredient3": "Onion",
                        "strIngredient4": "Garlic",
                        "strIngredient5": "Red Chilli",
                        "strIngredient6": "Tomato Puree",
                        "strIngredient7": "Pilchards",
                        "strIngredient8": "Black Olives",
                        "strIngredient9": "Parmesan",
                        "strIngredient10": "",
                        "strIngredient11": "",
                        "strIngredient12": "",
                        "strIngredient13": "",
                        "strIngredient14": "",
                        "strIngredient15": "",
                        "strIngredient16": "",
                        "strIngredient17": "",
                        "strIngredient18": "",
                        "strIngredient19": "",
                        "strIngredient20": "",
                        "strMeasure1": "300g",
                        "strMeasure2": "1 tbls",
                        "strMeasure3": "1 finely chopped ",
                        "strMeasure4": "2 cloves minced",
                        "strMeasure5": "1",
                        "strMeasure6": "1 tbls",
                        "strMeasure7": "425g",
                        "strMeasure8": "70g",
                        "strMeasure9": "Shaved",
                        "strMeasure10": "",
                        "strMeasure11": "",
                        "strMeasure12": "",
                        "strMeasure13": "",
                        "strMeasure14": "",
                        "strMeasure15": "",
                        "strMeasure16": "",
                        "strMeasure17": "",
                        "strMeasure18": "",
                        "strMeasure19": "",
                        "strMeasure20": ""
                    }]
                    """
                        ));
    }
    @Test
    void getMealsByFirstLetter_shouldReturnPutanescaWhenFirstLetterIsP() throws Exception{
        MealDto meal= new MealDto(
                "65798940147f2ee6720d3cae",
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
        mealController.addMeal(meal);
        mvc.perform(
                MockMvcRequestBuilders.get(BASE_URL+"/letter/P")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """

                                        [
                    {
                        "_id": "65798940147f2ee6720d3cae",
                        "idMeal": "52837",
                        "strMeal": "Pilchard puttanesca",
                        "strCategory": "Pasta",
                        "strArea": "Italian",
                        "strInstructions": "Cook the pasta following pack instructions. Heat the oil in a non-stick frying pan and cook the onion, garlic and chilli for 3-4 mins to soften. Stir in the tomato purée and cook for 1 min, then add the pilchards with their sauce. Cook, breaking up the fish with a wooden spoon, then add the olives and continue to cook for a few more mins.\\r\\n\\r\\nDrain the pasta and add to the pan with 2-3 tbsp of the cooking water. Toss everything together well, then divide between plates and serve, scattered with Parmesan.",
                        "strMealThumb": "https://www.themealdb.com/images/media/meals/vvtvtr1511180578.jpg",
                        "strTags": "",
                        "strIngredient1": "Spaghetti",
                        "strIngredient2": "Olive Oil",
                        "strIngredient3": "Onion",
                        "strIngredient4": "Garlic",
                        "strIngredient5": "Red Chilli",
                        "strIngredient6": "Tomato Puree",
                        "strIngredient7": "Pilchards",
                        "strIngredient8": "Black Olives",
                        "strIngredient9": "Parmesan",
                        "strIngredient10": "",
                        "strIngredient11": "",
                        "strIngredient12": "",
                        "strIngredient13": "",
                        "strIngredient14": "",
                        "strIngredient15": "",
                        "strIngredient16": "",
                        "strIngredient17": "",
                        "strIngredient18": "",
                        "strIngredient19": "",
                        "strIngredient20": "",
                        "strMeasure1": "300g",
                        "strMeasure2": "1 tbls",
                        "strMeasure3": "1 finely chopped ",
                        "strMeasure4": "2 cloves minced",
                        "strMeasure5": "1",
                        "strMeasure6": "1 tbls",
                        "strMeasure7": "425g",
                        "strMeasure8": "70g",
                        "strMeasure9": "Shaved",
                        "strMeasure10": "",
                        "strMeasure11": "",
                        "strMeasure12": "",
                        "strMeasure13": "",
                        "strMeasure14": "",
                        "strMeasure15": "",
                        "strMeasure16": "",
                        "strMeasure17": "",
                        "strMeasure18": "",
                        "strMeasure19": "",
                        "strMeasure20": ""
                    }]
"""
                        )
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void updateMeal_shouldChangeIngredient() throws Exception {
        MealDto meal= new MealDto(
                "65798940147f2ee6720d3cae",
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
                "Tomatalo Puree",
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
        mealController.addMeal(meal);
        MealDto newMeal= new MealDto("65798940147f2ee6720d3cae",
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
                "Tomatalo Puree",
                "Pilchards",
                "Black Olives",
                "Parmesan",
                "Icecream",
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
        mealController.updateMeal(meal.get_id(), newMeal);
        mvc.perform(
                MockMvcRequestBuilders.put(BASE_URL + "/update/" + meal.get_id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                    {
                        "_id": "65798940147f2ee6720d3cae",
                        "idMeal": "52837",
                        "strMeal": "Pilchard puttanesca",
                        "strCategory": "Pasta",
                        "strArea": "Italian",
                        "strInstructions": "Cook the pasta following pack instructions. Heat the oil in a non-stick frying pan and cook the onion, garlic and chilli for 3-4 mins to soften. Stir in the tomato purée and cook for 1 min, then add the pilchards with their sauce. Cook, breaking up the fish with a wooden spoon, then add the olives and continue to cook for a few more mins.\\r\\n\\r\\nDrain the pasta and add to the pan with 2-3 tbsp of the cooking water. Toss everything together well, then divide between plates and serve, scattered with Parmesan.",
                        "strMealThumb": "https://www.themealdb.com/images/media/meals/vvtvtr1511180578.jpg",
                        "strTags": "",
                        "strIngredient1": "Spaghetti",
                        "strIngredient2": "Olive Oil",
                        "strIngredient3": "Onion",
                        "strIngredient4": "Garlic",
                        "strIngredient5": "Red Chilli",
                        "strIngredient6": "Tomato Puree",
                        "strIngredient7": "Pilchards",
                        "strIngredient8": "Black Olives",
                        "strIngredient9": "Parmesan",
                        "strIngredient10": "Icecream",
                        "strIngredient11": "",
                        "strIngredient12": "",
                        "strIngredient13": "",
                        "strIngredient14": "",
                        "strIngredient15": "",
                        "strIngredient16": "",
                        "strIngredient17": "",
                        "strIngredient18": "",
                        "strIngredient19": "",
                        "strIngredient20": "",
                        "strMeasure1": "300g",
                        "strMeasure2": "1 tbls",
                        "strMeasure3": "1 finely chopped ",
                        "strMeasure4": "2 cloves minced",
                        "strMeasure5": "1",
                        "strMeasure6": "1 tbls",
                        "strMeasure7": "425g",
                        "strMeasure8": "70g",
                        "strMeasure9": "Shaved",
                        "strMeasure10": "",
                        "strMeasure11": "",
                        "strMeasure12": "",
                        "strMeasure13": "",
                        "strMeasure14": "",
                        "strMeasure15": "",
                        "strMeasure16": "",
                        "strMeasure17": "",
                        "strMeasure18": "",
                        "strMeasure19": "",
                        "strMeasure20": ""
                    }
"""
        ))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
*/
