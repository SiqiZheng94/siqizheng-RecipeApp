package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.CharacterCodingException;
import java.util.List;
import java.util.Locale;

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
    public MealRecord getRandomMeal() throws MealNotFoundException{
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
    public MealRecord getRandomMealByCategory(@PathVariable String category) throws CategoryNotFoundException{
        return service.getRandomMealByCategory(category);
    }
    @GetMapping("/letter/{letter}")
    public List<MealRecord> getMealsByFirstLetter(@PathVariable String letter) {
        return service.getMealsByFirstLetter(letter);
    }
    @GetMapping("/area/{area}")
    public List<MealRecord>getMealsByArea(@PathVariable String area) throws AreaNotFoundException{
        return service.getMealsByArea(area);
    }
    @GetMapping("/ingredient/{ingredient}")
    public List<MealRecord>getMealsByIngredient(@PathVariable String ingredient) throws IngredientNotFoundException{
        return service.getMealsByIngredient1(ingredient);
    }



//    @GetMapping("/category/")
//    public List<MealRecord> getMealsByCategoryQuery(@RequestParam String category) throws CategoryNotFoundException{
//        return service.getMealsByCategory(category);
//    }

    @GetMapping("/categorylist")
    public List <MealCategory> getAllCategories(){
        return service.getAllCategories();
    }

}
