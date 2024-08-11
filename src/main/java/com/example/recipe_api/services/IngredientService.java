package com.example.recipe_api.services;

import com.example.recipe_api.exceptions.ResourceNotFoundException;
import com.example.recipe_api.mapper.IngredientMapper;
import com.example.recipe_api.models.Ingredient;
import com.example.recipe_api.models.Recipe;
import com.example.recipe_api.models.dto.CreateIngredientDTO;
import com.example.recipe_api.models.dto.IngredientDTO;
import com.example.recipe_api.repositories.IngredientRepository;
import com.example.recipe_api.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;
    private final RecipeRepository recipeRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper, RecipeRepository recipeRepository){
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
        this.recipeRepository = recipeRepository;
    }

    public void createIngredientForRecipe(Long recipeId, CreateIngredientDTO createIngredientDTO) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));

        Ingredient ingredient = ingredientMapper.fromCreateIngredientDTO(createIngredientDTO);
        ingredient.setRecipe(recipe);

        ingredientRepository.save(ingredient);
    }

    // Get an ingredient by ID
    public Optional<IngredientDTO> getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .map(ingredientMapper::toDTO);
    }

    // Get all ingredients
    public List<IngredientDTO> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(ingredientMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Delete an ingredient
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
