package org.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

   /*@Autowired*/
    private final MealRepo repo;
    private final MealCategoryRepo categoryRepo;

    public List<MealRecord> getAllMeals() {
        return repo.findAll();
    }

    public MealRecord getRandomMeal(){
        //return repo.findAll().get((int) (Math.random() * repo.findAll().size()));
        int randomIndex=(int)(Math.random()* repo.count());
        return repo.findAll().get(randomIndex);

    }

    //getById
    public MealRecord getMealById(String _id) {
        return repo.findById(_id).orElse(null);
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
        //MealCategory mealCategory=MealCategory.fromString(category);

        return repo.findAllByStrCategoryIgnoreCase(category)
                .orElseThrow(() ->new CategoryNotFoundException("The category you are searching for is not existing"));
    }

    public List <MealRecord> getMealsByArea(String area) throws AreaNotFoundException{
        return repo.findAllByStrAreaIgnoreCase(area)
                .orElseThrow(()-> new AreaNotFoundException("Area not found exception"));
    }
    public List <MealRecord> getMealsByIngredient1(String ingredient) throws IngredientNotFoundException {
        return repo.findAllByStrIngredient1ContainingIgnoreCase(ingredient)
                .orElseThrow(()->new IngredientNotFoundException("Ingredient not found"));
    }


    public MealRecord addMeal(MealRecord mealRecord){
        return repo.insert(mealRecord);
    }

    public MealRecord updateMeal(String _id, MealRecord mealRecord){
        mealRecord = mealRecord.with_id(_id);
        return repo.save(mealRecord);
    }

    public void deleteMeal(String _id) {
        repo.deleteById(_id);
    }

    public List <MealCategory> getAllCategories(){
        return categoryRepo.findAll();

    }

}

