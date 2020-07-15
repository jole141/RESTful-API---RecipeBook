package com.jole141.recipeAPI.dao;

import com.jole141.recipeAPI.model.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecipeDao {

    int insertRecipe(UUID id, Recipe recipe);

    default int insertRecipe(Recipe recipe) {
        UUID id = UUID.randomUUID();
        return insertRecipe(id, recipe);
    }

    List<Recipe> selectAllRecipes();

    Optional<Recipe> selectRecipeById(UUID id);

    int deleteRecipeById(UUID id);

    int updateRecipeById(UUID id, Recipe recipe);
}
