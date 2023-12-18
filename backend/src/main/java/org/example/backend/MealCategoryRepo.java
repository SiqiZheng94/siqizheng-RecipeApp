package org.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealCategoryRepo extends MongoRepository <MealCategory,String>{

}
