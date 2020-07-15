package com.jole141.recipeAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Recipe {

    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String ingredients;

    public Recipe(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("ingredients") String ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }
}
