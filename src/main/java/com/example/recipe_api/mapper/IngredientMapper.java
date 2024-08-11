package com.example.recipe_api.mapper;

import com.example.recipe_api.models.Ingredient;
import com.example.recipe_api.models.dto.CreateIngredientDTO;
import com.example.recipe_api.models.dto.IngredientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientDTO toDTO(Ingredient ingredient);
    Ingredient toIngredient(IngredientDTO dto);
    Ingredient fromCreateIngredientDTO(CreateIngredientDTO dto);
}
