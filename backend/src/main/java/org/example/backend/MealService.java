package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    @Autowired
    private final MealRepo repo;

    public List<MealRecord> getAllMeals() {
        return repo.findAll();
    }

    public MealRecord getRandomMeal() {
        return repo.findAll().get((int) (Math.random() * repo.findAll().size()));
    }

    //getById
    public MealRecord getMealById(String _id) {
        return repo.findById(_id).orElse(null);
    }


    public MealRecord getRandomMealByCategory(String category) {
        List<MealRecord> meals = repo.findAllByStrCategoryIgnoreCase(category);
        if (!meals.isEmpty()) {
            return meals.get((int) (Math.random() * meals.size()));
        }
        return null;
    }

    public List<MealRecord> getMealsByCategory(String category) {
        return repo.findAllByStrCategoryIgnoreCase(category);
    }
}
