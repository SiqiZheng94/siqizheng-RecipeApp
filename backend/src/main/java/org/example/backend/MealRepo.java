package org.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MealRepo extends MongoRepository<MealRecord, String> {

    List<MealRecord> findAllByStrTagsContaining(String tag);

    List<MealRecord> findAllByStrCategory(String vegan);
}
