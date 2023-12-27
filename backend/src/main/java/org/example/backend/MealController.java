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
    private final IdService idService;
    private final MealService service;

    @GetMapping
    public List<MealRecord> getAllMeals() {
        return service.getAllMeals();
    }

    @GetMapping("/random")
    public MealRecord getRandomMeal() throws MealNotFoundException{
        return service.getRandomMeal();
    }

    @GetMapping("/{id}")
    public MealRecord getMealById(@PathVariable String id) {
        return service.getMealById(id);
    }

    @GetMapping("/name/{name}")
    public List<MealRecord> getMealsByName(@PathVariable String name) {
        return service.getMealsByName(name);
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



    @GetMapping("/categorylist")
    public List <MealCategory> getAllCategories(){
        return service.getAllCategories();

    }

//    @PostMapping("/add")
//    public MealRecord addMeal(@RequestBody MealDto mealDto) {
//        MealRecord mealRecord = convertToRecord(mealDto);
//        return service.addMeal(mealRecord);
//    }
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



private MealRecord convertToRecord(MealDto mealDto){
        return service.saveMeal(mealDto);
}


    @GetMapping("/category")
    public List <MealRecord> getMealsByCategoryAndFirstLetter(@RequestParam String category,@RequestParam String letter) throws MealNotFoundException{
        return service.getMealsByCategoryAndFirstLetter(category,letter);
    }
    @GetMapping("/area")
    public List <MealRecord> getMealsByAreaAndFirstLetter(@RequestParam String area,@RequestParam String letter) throws MealNotFoundException{
        return service.getMealsByAreaAndFirstLetter(area,letter);
    }

}
