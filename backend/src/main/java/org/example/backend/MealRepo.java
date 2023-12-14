package org.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface MealRepo extends MongoRepository<MealRecord, String> {
    List<MealRecord> findAllByStrTagsContainingIgnoreCase(String tag);
    List<MealRecord> findAllByStrCategoryIgnoreCase(String strCategory);
    List<MealRecord> findAllByStrTagsContaining(String tag);

    List<MealRecord> findAllByStrCategory(String vegan);
    List<MealRecord> findAllByStrMealStartingWithIgnoreCase(String letter);
}
