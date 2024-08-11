package com.example.recipe_api.mapper;

import com.example.recipe_api.models.Recipe;
import com.example.recipe_api.models.dto.CreateRecipeDTO;
import com.example.recipe_api.models.dto.RecipeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {IngredientMapper.class})
public interface RecipeMapper {

    @Mapping(source = "ingredients", target = "ingredients")
    RecipeDTO toRecipeDTO(Recipe recipe);
    Recipe toRecipe(RecipeDTO recipeDTO);
    Recipe fromCreateRecipeDTO(CreateRecipeDTO createRecipeDTO);
}
