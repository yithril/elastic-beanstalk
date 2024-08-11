package com.example.recipe_api.mapper;

import com.example.recipe_api.models.Recipe;
import com.example.recipe_api.models.dto.CreateRecipeDTO;
import com.example.recipe_api.models.dto.RecipeDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeDTO toRecipeDTO(Recipe recipe);
    Recipe toRecipe(RecipeDTO recipeDTO);
    Recipe fromCreateRecipeDTO(CreateRecipeDTO createRecipeDTO);
}
