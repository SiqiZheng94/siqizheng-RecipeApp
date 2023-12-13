package org.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface MealRepo extends MongoRepository<MealRecord, String> {

}
