package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

    public List<MealRecord> getAllVeganMeals() {
        return repo.findAllByStrCategory("vegan");
    }


    public MealRecord getRandomVeganMeal() {
        List<MealRecord> veganMeals = repo.findAllByStrTagsContaining("vegan");
        if (!veganMeals.isEmpty()) {
            return veganMeals.get((int) (Math.random() * veganMeals.size()));
        }
        return null; // oder eine geeignete Behandlung, falls keine veganen Mahlzeiten gefunden werden
    }

    public List <MealRecord> getMealsByCategory(String category){
        MealCategory mealCategory=MealCategory.fromString(category);
        return repo.findAllByStrCategory(mealCategory.getCategoryName());
    }

}
