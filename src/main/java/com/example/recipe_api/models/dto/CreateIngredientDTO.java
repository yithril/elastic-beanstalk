package com.example.recipe_api.models.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateIngredientDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String quantity;

    public CreateIngredientDTO(){

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
