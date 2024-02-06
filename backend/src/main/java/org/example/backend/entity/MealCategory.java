package org.example.backend.entity;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document("meal_categories")
public record MealCategory(
        String _id,
        String idCategory,
        String strCategory,
        String strCategoryThumb
) {
}


