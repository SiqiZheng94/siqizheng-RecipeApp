package org.example.backend.repo;

import org.example.backend.entity.MealCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealCategoryRepo extends MongoRepository <MealCategory,String>{

}
