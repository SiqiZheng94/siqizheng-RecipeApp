package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepo repo;
    private final MealCategoryRepo categoryRepo;
    private final IdService idService;

    public List<MealRecord> getAllMeals() {
        return repo.findAll();
    }

    public MealRecord getRandomMeal(){
        int randomIndex=(int)(Math.random()* repo.count());
        return repo.findAll().get(randomIndex);

    }


    public MealRecord getMealById(String id) {
        return repo.findById(id).orElse(null);
    }


    public MealRecord getRandomMealByCategory(String category) throws CategoryNotFoundException{
        List<MealRecord> meals = repo.findAllByStrCategoryIgnoreCase(category)
                .orElseThrow(()->new CategoryNotFoundException("No such category found"));
        return meals.get((int) (Math.random() * meals.size()));

    }
/*
    public List<MealRecord> getMealsByCategory(String category) {
        return repo.findAllByStrCategoryIgnoreCase(category);
    }
*/

    public List<MealRecord> getMealsByFirstLetter(String letter) {
        return repo.findAllByStrMealStartingWithIgnoreCase(letter);
    }

    public List <MealRecord> getMealsByCategory(String category) throws CategoryNotFoundException{
        return repo.findAllByStrCategoryIgnoreCase(category)
                .orElseThrow(() ->new CategoryNotFoundException("The category you are searching for is not existing"));
    }
    public List <MealRecord> getMealsByCategoryAndFirstLetter(String category, String letter) throws MealNotFoundException{
        return repo.findAllByStrCategoryAndStrMealIsStartingWith(category,letter)
                .orElseThrow(()-> new MealNotFoundException("No meals found for for category: \" + category + \" and starting letter: \" + letter"));
    }

    public List <MealRecord> getMealsByArea(String area) throws AreaNotFoundException{
        return repo.findAllByStrAreaIgnoreCase(area)
                .orElseThrow(()-> new AreaNotFoundException("Area not found exception"));
    }

    public List<MealRecord> getMealsByAreaAndFirstLetter(String area,String letter) throws MealNotFoundException{
        return repo.findAllByStrAreaAndStrMealIsStartingWith(area,letter)
                .orElseThrow(() ->new MealNotFoundException("No meals found for area: " + area + "and starting letter: "+ letter));
    }
    public List <MealRecord> getMealsByIngredient1(String ingredient) throws IngredientNotFoundException {
        return repo.findAllByStrIngredient1ContainingIgnoreCase(ingredient)
                .orElseThrow(()->new IngredientNotFoundException("Ingredient not found"));
    }


    public MealRecord addMeal(MealRecord mealRecord){
        return repo.insert(mealRecord);
    }

    public MealRecord updateMeal( MealRecord mealRecord){
        return repo.save(mealRecord);
    }

    public void deleteMeal(String id) {
        repo.deleteById(id);
    }

    public List <MealCategory> getAllCategories(){
        return categoryRepo.findAll();

    }

    public List<MealRecord> getMealsByName(String name) {
        return repo.findAllByStrMealContainingIgnoreCase(name);
    }

//////////
    public MealRecord saveMeal (MealDto mealDto){
        String defaultImage = "./defaultImage.jpeg";
        String mealThumb=(mealDto.getStrMealThumb()!=null && !mealDto.getStrMealThumb().isEmpty())
                ? mealDto.getStrMealThumb()
                : defaultImage;
        MealRecord newMealRecord = new MealRecord(
                null,
                idService.randomId(),
                mealDto.getStrMeal() != null ? mealDto.getStrMeal() : "",
                mealDto.getStrCategory() != null ? mealDto.getStrCategory() : "",
                mealDto.getStrArea() != null ? mealDto.getStrArea() : "",
                mealDto.getStrInstructions() != null ? mealDto.getStrInstructions() : "",
                mealThumb,
                //mealDto.getStrMealThumb() != null ? mealDto.getStrMealThumb() : defaultImage,
                mealDto.getStrTags() != null ? mealDto.getStrTags() : "",
                mealDto.getStrIngredient1() != null ? mealDto.getStrIngredient1() : "",
                mealDto.getStrIngredient2() != null ? mealDto.getStrIngredient2() : "",
                mealDto.getStrIngredient3() != null ? mealDto.getStrIngredient3() : "",
                mealDto.getStrIngredient4() != null ? mealDto.getStrIngredient4() : "",
                mealDto.getStrIngredient5() != null ? mealDto.getStrIngredient5() : "",
                mealDto.getStrIngredient6() != null ? mealDto.getStrIngredient6() : "",
                mealDto.getStrIngredient7() != null ? mealDto.getStrIngredient7() : "",
                mealDto.getStrIngredient8() != null ? mealDto.getStrIngredient8() : "",
                mealDto.getStrIngredient9() != null ? mealDto.getStrIngredient9() : "",
                mealDto.getStrIngredient10() != null ? mealDto.getStrIngredient10() : "",
                mealDto.getStrIngredient11() != null ? mealDto.getStrIngredient11() : "",
                mealDto.getStrIngredient12() != null ? mealDto.getStrIngredient12() : "",
                mealDto.getStrIngredient13() != null ? mealDto.getStrIngredient13() : "",
                mealDto.getStrIngredient14() != null ? mealDto.getStrIngredient14() : "",
                mealDto.getStrIngredient15() != null ? mealDto.getStrIngredient15() : "",
                mealDto.getStrIngredient16() != null ? mealDto.getStrIngredient16() : "",
                mealDto.getStrIngredient17() != null ? mealDto.getStrIngredient17() : "",
                mealDto.getStrIngredient18() != null ? mealDto.getStrIngredient18() : "",
                mealDto.getStrIngredient19() != null ? mealDto.getStrIngredient19() : "",
                mealDto.getStrIngredient20() != null ? mealDto.getStrIngredient20() : "",
                mealDto.getStrMeasure1() != null ? mealDto.getStrMeasure1() : "",
                mealDto.getStrMeasure2() != null ? mealDto.getStrMeasure2() : "",
                mealDto.getStrMeasure3() != null ? mealDto.getStrMeasure3() : "",
                mealDto.getStrMeasure4() != null ? mealDto.getStrMeasure4() : "",
                mealDto.getStrMeasure5() != null ? mealDto.getStrMeasure5() : "",
                mealDto.getStrMeasure6() != null ? mealDto.getStrMeasure6() : "",
                mealDto.getStrMeasure7() != null ? mealDto.getStrMeasure7() : "",
                mealDto.getStrMeasure8() != null ? mealDto.getStrMeasure8() : "",
                mealDto.getStrMeasure9() != null ? mealDto.getStrMeasure9() : "",
                mealDto.getStrMeasure10() != null ? mealDto.getStrMeasure10() : "",
                mealDto.getStrMeasure11() != null ? mealDto.getStrMeasure11() : "",
                mealDto.getStrMeasure12() != null ? mealDto.getStrMeasure12() : "",
                mealDto.getStrMeasure13() != null ? mealDto.getStrMeasure13() : "",
                mealDto.getStrMeasure14() != null ? mealDto.getStrMeasure14() : "",
                mealDto.getStrMeasure15() != null ? mealDto.getStrMeasure15() : "",
                mealDto.getStrMeasure16() != null ? mealDto.getStrMeasure16() : "",
                mealDto.getStrMeasure17() != null ? mealDto.getStrMeasure17() : "",
                mealDto.getStrMeasure18() != null ? mealDto.getStrMeasure18() : "",
                mealDto.getStrMeasure19() != null ? mealDto.getStrMeasure19() : "",
                mealDto.getStrMeasure20() != null ? mealDto.getStrMeasure20() : ""
        );
        return repo.save(newMealRecord);
    }
///////////

}

