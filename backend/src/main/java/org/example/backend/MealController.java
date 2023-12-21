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

    @PutMapping("/update/{id}")
    public MealRecord updateMeal(@PathVariable String id, @RequestBody MealDto mealDto) {
        MealRecord mealRecord = convertToRecord(mealDto);
        return service.updateMeal(mealRecord);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMeal(@PathVariable String id) {
        service.deleteMeal(id);
    }

//    private MealRecord convertToRecord(MealDto mealDto) {
//        return new MealRecord(
//                null,
//                idService.randomId(),
//                mealDto.getStrMeal() != null ? mealDto.getStrMeal() : "",
//                mealDto.getStrCategory() != null ? mealDto.getStrCategory() : "",
//                mealDto.getStrArea() != null ? mealDto.getStrArea() : "",
//                mealDto.getStrInstructions() != null ? mealDto.getStrInstructions() : "",
//                mealDto.getStrMealThumb() != null ? mealDto.getStrMealThumb() : "",
//                mealDto.getStrTags() != null ? mealDto.getStrTags() : "",
//                mealDto.getStrIngredient1() != null ? mealDto.getStrIngredient1() : "",
//                mealDto.getStrIngredient2() != null ? mealDto.getStrIngredient2() : "",
//                mealDto.getStrIngredient3() != null ? mealDto.getStrIngredient3() : "",
//                mealDto.getStrIngredient4() != null ? mealDto.getStrIngredient4() : "",
//                mealDto.getStrIngredient5() != null ? mealDto.getStrIngredient5() : "",
//                mealDto.getStrIngredient6() != null ? mealDto.getStrIngredient6() : "",
//                mealDto.getStrIngredient7() != null ? mealDto.getStrIngredient7() : "",
//                mealDto.getStrIngredient8() != null ? mealDto.getStrIngredient8() : "",
//                mealDto.getStrIngredient9() != null ? mealDto.getStrIngredient9() : "",
//                mealDto.getStrIngredient10() != null ? mealDto.getStrIngredient10() : "",
//                mealDto.getStrIngredient11() != null ? mealDto.getStrIngredient11() : "",
//                mealDto.getStrIngredient12() != null ? mealDto.getStrIngredient12() : "",
//                mealDto.getStrIngredient13() != null ? mealDto.getStrIngredient13() : "",
//                mealDto.getStrIngredient14() != null ? mealDto.getStrIngredient14() : "",
//                mealDto.getStrIngredient15() != null ? mealDto.getStrIngredient15() : "",
//                mealDto.getStrIngredient16() != null ? mealDto.getStrIngredient16() : "",
//                mealDto.getStrIngredient17() != null ? mealDto.getStrIngredient17() : "",
//                mealDto.getStrIngredient18() != null ? mealDto.getStrIngredient18() : "",
//                mealDto.getStrIngredient19() != null ? mealDto.getStrIngredient19() : "",
//                mealDto.getStrIngredient20() != null ? mealDto.getStrIngredient20() : "",
//                mealDto.getStrMeasure1() != null ? mealDto.getStrMeasure1() : "",
//                mealDto.getStrMeasure2() != null ? mealDto.getStrMeasure2() : "",
//                mealDto.getStrMeasure3() != null ? mealDto.getStrMeasure3() : "",
//                mealDto.getStrMeasure4() != null ? mealDto.getStrMeasure4() : "",
//                mealDto.getStrMeasure5() != null ? mealDto.getStrMeasure5() : "",
//                mealDto.getStrMeasure6() != null ? mealDto.getStrMeasure6() : "",
//                mealDto.getStrMeasure7() != null ? mealDto.getStrMeasure7() : "",
//                mealDto.getStrMeasure8() != null ? mealDto.getStrMeasure8() : "",
//                mealDto.getStrMeasure9() != null ? mealDto.getStrMeasure9() : "",
//                mealDto.getStrMeasure10() != null ? mealDto.getStrMeasure10() : "",
//                mealDto.getStrMeasure11() != null ? mealDto.getStrMeasure11() : "",
//                mealDto.getStrMeasure12() != null ? mealDto.getStrMeasure12() : "",
//                mealDto.getStrMeasure13() != null ? mealDto.getStrMeasure13() : "",
//                mealDto.getStrMeasure14() != null ? mealDto.getStrMeasure14() : "",
//                mealDto.getStrMeasure15() != null ? mealDto.getStrMeasure15() : "",
//                mealDto.getStrMeasure16() != null ? mealDto.getStrMeasure16() : "",
//                mealDto.getStrMeasure17() != null ? mealDto.getStrMeasure17() : "",
//                mealDto.getStrMeasure18() != null ? mealDto.getStrMeasure18() : "",
//                mealDto.getStrMeasure19() != null ? mealDto.getStrMeasure19() : "",
//                mealDto.getStrMeasure20() != null ? mealDto.getStrMeasure20() : ""
//        );
//    }
    //////////////////
private MealRecord convertToRecord(MealDto mealDto){
        return service.saveMeal(mealDto);
}
/////////////////////

    @GetMapping("/category")
    public List <MealRecord> getMealsByCategoryAndFirstLetter(@RequestParam String category,@RequestParam String letter) throws MealNotFoundException{
        return service.getMealsByCategoryAndFirstLetter(category,letter);
    }
    @GetMapping("/area")
    public List <MealRecord> getMealsByAreaAndFirstLetter(@RequestParam String area,@RequestParam String letter) throws MealNotFoundException{
        return service.getMealsByAreaAndFirstLetter(area,letter);
    }

}
