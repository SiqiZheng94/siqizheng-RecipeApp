package org.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface MealRepo extends MongoRepository<MealRecord, String> {
    List<MealRecord> findAllByStrTagsContainingIgnoreCase(String tag);
    public Optional<List<MealRecord>> findAllByStrCategoryIgnoreCase(String strCategory);
    List<MealRecord> findAllByStrTagsContaining(String tag);

    List<MealRecord> findAllByStrMealStartingWithIgnoreCase(String letter);
    public Optional<List<MealRecord>> findAllByStrAreaIgnoreCase(String area);
    public Optional<List<MealRecord>> findAllByStrIngredient1ContainingIgnoreCase(String ingredient);
    public Optional<List<MealRecord>> findAllByStrCategoryAndStrMealIsStartingWith(String category,String letter);
    public Optional<List<MealRecord>> findAllByStrAreaAndStrMealIsStartingWith(String area,String letter);

}
