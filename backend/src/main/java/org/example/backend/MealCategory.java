package org.example.backend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

import java.util.Arrays;

@Getter
@AllArgsConstructor

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
    }
}
