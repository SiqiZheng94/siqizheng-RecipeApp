package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor
public class MealController {
    private final IdService idService;
    private final MealService service;

    @GetMapping
    public List<MealRecord> getAllMeals() {
        return service.getAllMeals();
    }

    @GetMapping("/{id}")
    public MealRecord getMealById(@PathVariable String id) throws NotFoundException {
        return service.getMealById(id);
    }

    @GetMapping("/name/{name}")
    public List<MealRecord> getMealsByName(@PathVariable String name) throws NotFoundException {
        return service.getMealsByName(name);
    }

    @GetMapping("/category/{category}")
    public List<MealRecord> getMealsByCategory(@PathVariable String category) throws NotFoundException {
        return service.getMealsByCategory(category);
    }



    @GetMapping("/letter/{letter}")
    public List<MealRecord> getMealsByFirstLetter(@PathVariable String letter) throws NotFoundException {
        return service.getMealsByFirstLetter(letter);
    }


    @GetMapping("/categorylist")
    public List <MealCategory> getAllCategories(){
        return service.getAllCategories();

    }

    @PostMapping("/add")
    public MealRecord addMeal(@RequestBody MealDto mealDto) {
        return service.saveMeal(mealDto);
    }

    @PutMapping("/update")
    public MealRecord updateMeal( @RequestBody MealRecord mealRecord) {
        return service.updateMeal(mealRecord);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMeal(@PathVariable String id) {
        service.deleteMeal(id);
    }
}
