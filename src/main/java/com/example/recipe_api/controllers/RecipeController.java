package com.example.recipe_api.controllers;

import com.example.recipe_api.models.dto.CreateIngredientDTO;
import com.example.recipe_api.models.dto.CreateRecipeDTO;
import com.example.recipe_api.models.dto.RecipeDTO;
import com.example.recipe_api.models.dto.UpdateRecipeDTO;
import com.example.recipe_api.services.IngredientService;
import com.example.recipe_api.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Recipe")
public class RecipeController {
    private RecipeService recipeService;
    private final IngredientService ingredientService;

    @Autowired
    public RecipeController(RecipeService recipeService, IngredientService ingredientService){
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getRecipes(){
        var recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id){
       return new ResponseEntity<>(recipeService.getRecipeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@Valid @RequestBody CreateRecipeDTO dto){
        var recipe = recipeService.createRecipe(dto);

        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@Valid @RequestBody UpdateRecipeDTO dto,
                                                  @PathVariable Long id){
        var recipe = recipeService.updateRecipe(dto, id);

        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/{recipeId}/ingredients")
    public ResponseEntity<RecipeDTO> addIngredientToRecipe(@PathVariable Long recipeId,
                                                           @Valid @RequestBody CreateIngredientDTO createIngredientDTO) {
        ingredientService.createIngredientForRecipe(recipeId, createIngredientDTO);
        var updatedRecipeDTO = recipeService.getRecipeById(recipeId);
        return new ResponseEntity<>(updatedRecipeDTO, HttpStatus.CREATED);
    }
}
