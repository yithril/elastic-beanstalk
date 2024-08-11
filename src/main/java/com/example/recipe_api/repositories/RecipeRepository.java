package com.example.recipe_api.repositories;

import com.example.recipe_api.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    //derived queries
    List<Recipe> findByNameContainingIgnoreCase(String name);
    List<Recipe> findByCookingTimeInMinutesBetween(int start, int end);
}
