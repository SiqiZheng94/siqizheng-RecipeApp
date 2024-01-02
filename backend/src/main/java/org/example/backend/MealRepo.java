package org.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface MealRepo extends MongoRepository<MealRecord, String> {
    List<MealRecord> findAllByStrTagsContainingIgnoreCase(String tag);
    public List<MealRecord> findAllByStrCategoryIgnoreCase(String strCategory);
    List<MealRecord> findAllByStrTagsContaining(String tag);

    List<MealRecord> findAllByStrMealStartingWithIgnoreCase(String letter);
    public List<MealRecord> findAllByStrAreaIgnoreCase(String area);

    List<MealRecord> findAllByStrMealContainingIgnoreCase(String name);
    List<MealRecord> findAllByStrIngredient1IgnoreCase(String ingredient);
}
