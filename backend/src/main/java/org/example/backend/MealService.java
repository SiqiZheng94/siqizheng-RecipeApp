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
}

