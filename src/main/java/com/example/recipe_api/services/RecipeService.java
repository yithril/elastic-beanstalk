package com.example.recipe_api.services;

import com.example.recipe_api.exceptions.ResourceNotFoundException;
import com.example.recipe_api.mapper.RecipeMapper;
import com.example.recipe_api.models.Recipe;
import com.example.recipe_api.models.dto.CreateRecipeDTO;
import com.example.recipe_api.models.dto.RecipeDTO;
import com.example.recipe_api.models.dto.UpdateRecipeDTO;
import com.example.recipe_api.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDTO> getAllRecipes(){
        List<Recipe> recipes = this.recipeRepository.findAll();
        return recipes.stream().map(recipeMapper::toRecipeDTO).toList();
    }

    public RecipeDTO getRecipeById(Long id){
        var recipe = this.recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

        return recipeMapper.toRecipeDTO(recipe);
    }

    public void deleteRecipe(Long id){
        //check to see if the recipe they want actually exists
        //if it doesn't, ill throw an exception, if it does cool
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

        recipeRepository.delete(recipe);
    }

    public RecipeDTO createRecipe(CreateRecipeDTO dto){
        Recipe recipe = recipeMapper.fromCreateRecipeDTO(dto);
        Recipe createdRecipe = recipeRepository.save(recipe);
        return recipeMapper.toRecipeDTO(createdRecipe);
    }

    public RecipeDTO updateRecipe(UpdateRecipeDTO dto, Long id){
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

        recipe.setName(dto.getName());
        recipe.setInstructions(dto.getInstructions());
        recipe.setCookingTimeInMinutes(dto.getCookingTimeInMinutes());
        recipe.setVegan(dto.isVegan());
        recipe.setNutFree(dto.isNutFree());
        recipe.setGlutenFree(dto.isGlutenFree());

        Recipe updatedRecipe = recipeRepository.save(recipe);

        return recipeMapper.toRecipeDTO(updatedRecipe);
    }
}
