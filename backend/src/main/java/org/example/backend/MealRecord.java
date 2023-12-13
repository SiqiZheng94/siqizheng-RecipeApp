package org.example.backend;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@With
//@Document("meals")
public record MealRecord(

        String _id,
        String idMeal,
        String strMeal,
        String strCategory,
        String strArea,
        String strInstructions,
        String strMealThumb,
        String strTags,
        String strIngredient1,
        String strIngredient2,
        String strIngredient3,
        String strIngredient4,
        String strIngredient5,
        String strIngredient6,
        String strIngredient7,
        String strIngredient8,
        String strIngredient9,
        String strIngredient10,
        String strMeasure1,
        String strMeasure2,
        String strMeasure3,
        String strMeasure4,
        String strMeasure5,
        String strMeasure6,
        String strMeasure7,
        String strMeasure8,
        String strMeasure9,
        String strMeasure10

            )  {
}
