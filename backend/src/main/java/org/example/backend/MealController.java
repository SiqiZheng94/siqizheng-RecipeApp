package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.CharacterCodingException;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor
public class MealController {

//    @Autowired
    private final MealService service;

    @GetMapping
    public List<MealRecord> getAllMeals() {
        return service.getAllMeals();
    }

    @GetMapping("/random")
    public MealRecord getRandomMeal() {
        return service.getRandomMeal();
    }

    @GetMapping("/{_id}")
    public MealRecord getMealById(@PathVariable String _id) {
        return service.getMealById(_id);
    }

    @GetMapping("/category/{category}")
    public List<MealRecord> getMealsByCategory(@PathVariable String category) throws CategoryNotFoundException{
        return service.getMealsByCategory(category);
    }

    @GetMapping("category/{category}/random")
    public MealRecord getRandomMealByCategory(@PathVariable String category) {
        return service.getRandomMealByCategory(category);
    }
    @GetMapping("/letter/{letter}")
    public List<MealRecord> getMealsByFirstLetter(@PathVariable String letter) {
        return service.getMealsByFirstLetter(letter);
    }


    }
