package com.example.recipe_api.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateRecipeDTO {
    @NotBlank(message = "Name is mandatory.")
    @Size(max = 100, message = "Name can be at most 100 characters")
    private String name;

    @NotBlank(message = "Instructions are necessary.")
    private String instructions;

    @Min(value = 1, message = "Cooking time should be at least 1 minute")
    private int cookingTimeInMinutes;
    private boolean isVegan;
    private boolean isNutFree;
    private boolean isGlutenFree;

    public CreateRecipeDTO(){

    }

    public CreateRecipeDTO(String name, String instructions, int cookingTimeInMinutes, boolean isVegan, boolean isNutFree, boolean isGlutenFree) {
        this.name = name;
        this.instructions = instructions;
        this.cookingTimeInMinutes = cookingTimeInMinutes;
        this.isVegan = isVegan;
        this.isNutFree = isNutFree;
        this.isGlutenFree = isGlutenFree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getCookingTimeInMinutes() {
        return cookingTimeInMinutes;
    }

    public void setCookingTimeInMinutes(int cookingTimeInMinutes) {
        this.cookingTimeInMinutes = cookingTimeInMinutes;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isNutFree() {
        return isNutFree;
    }

    public void setNutFree(boolean nutFree) {
        isNutFree = nutFree;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }
}
