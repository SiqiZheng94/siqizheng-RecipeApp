package org.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepo repo;

    public List<MealRecord> getAllMeals() {
        return repo.findAll();
    }
}
