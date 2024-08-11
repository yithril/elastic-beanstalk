package com.example.recipe_api.models.dto;

import com.example.recipe_api.services.IngredientService;
import jakarta.validation.constraints.NotBlank;

public class IngredientDTO {
    private String name;
    private String quantity;

    public IngredientDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
