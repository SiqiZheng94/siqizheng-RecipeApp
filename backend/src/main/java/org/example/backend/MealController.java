package org.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService service;

    @GetMapping
    public List<MealRecord> getAllMeals() {
        return service.getAllMeals();
    }

    @GetMapping("/random")
    public MealRecord getRandomMeal() {
        return service.getRandomMeal();
    }

    @GetMapping("/{_id}")
    public MealRecord getMealById(String _id) {
        return service.getMealById(_id);
    }

    @GetMapping("/vegan")
    public List<MealRecord> getAllVeganMeals() {
        return service.getAllVeganMeals();
    }

    @GetMapping("/random/vegan")
    public MealRecord getRandomVeganMeal() {
        return service.getRandomVeganMeal();
    }
}