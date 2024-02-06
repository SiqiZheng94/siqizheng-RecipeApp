package org.example.backend.service;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.MealDto;
import org.example.backend.entity.MealCategory;
import org.example.backend.entity.MealRecord;
import org.example.backend.exception.NotFoundException;
import org.example.backend.repo.MealCategoryRepo;
import org.example.backend.repo.MealRepo;
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



    public MealRecord getMealById(String id) throws NotFoundException {

        return repo.findById(id)
                .orElseThrow(()->new NotFoundException("Meal with ID:" + id + " isn't found."));
    }


    public List<MealRecord> getMealsByFirstLetter(String letter) throws NotFoundException {
        List<MealRecord> allMeals = repo.findAllByStrMealStartingWithIgnoreCase(letter);
        //if (allMeals.isEmpty()){
        //    throw new NotFoundException("There isn't any mal with first letter: "+letter);
        //}
        return allMeals;
    }

    public List <MealRecord> getMealsByCategory(String category) throws NotFoundException{
        List<MealRecord> allMeals = repo.findAllByStrCategoryIgnoreCase(category);
        if (allMeals.isEmpty()){
            throw new NotFoundException("The category you are searching for is not existing.");
        }
        return allMeals;
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

    public List<MealRecord> getMealsByName(String name) throws NotFoundException {
        List<MealRecord> allMeals = repo.findAllByStrMealContainingIgnoreCase(name);
        if (allMeals.isEmpty()){
            throw new NotFoundException("There isn't any meal with name: "+name);
        }
        return allMeals;
    }


    public MealRecord saveMeal (MealDto mealDto){
        MealRecord newMealRecord = new MealRecord(
                null,
                idService.randomId(),
                mealDto.getStrMeal() != "" ? mealDto.getStrMeal() : "Test",
                mealDto.getStrCategory() != null ? mealDto.getStrCategory() : "",
                mealDto.getStrArea() != null ? mealDto.getStrArea() : "",
                mealDto.getStrInstructions() != null ? mealDto.getStrInstructions() : "",
                mealDto.getStrMealThumb() != "" ? mealDto.getStrMealThumb() : "https://cdn.pixabay.com/photo/2014/12/21/23/28/recipe-575434_960_720.png",
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
}