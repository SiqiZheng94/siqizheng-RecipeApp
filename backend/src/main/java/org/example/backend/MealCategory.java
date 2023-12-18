package org.example.backend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


/*
public enum MealCategory {
    BEEF("Beef"),
    BREAKFAST("Breakfast"),
    CHICKEN("Chicken"),
    DESSERT("Dessert"),
    GOAT("Goat"),
    LAMB("Lamb"),
    MISCELLANEOUS("Miscellaneous"),
    PASTA("Pasta"),
    PORK("Pork"),
    SEAFOOD("Seafood"),
    SIDE("Side"),
    STARTER("Starter"),
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian");
    private final String categoryName;
    public static MealCategory fromString(String categoryString) {
        return Arrays.stream(MealCategory.values())
                .filter(category -> category.getCategoryName().equalsIgnoreCase(categoryString))
                .findFirst()
                .orElse(null);
    }*/
@With
@Document("meal_categories")
public record MealCategory(
        String _id,
        String idCategory,
        String strCategory,
        String strCategoryThumb
) {
}


