package com.jole141.recipeAPI.dao;

import com.jole141.recipeAPI.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("recipeDao")
public class RecipeDataAccessService implements RecipeDao {

    private static List<Recipe> DB = new ArrayList<>();

    @Override
    public int insertRecipe(UUID id, Recipe recipe) {
        DB.add(new Recipe(id, recipe.getName(), recipe.getIngredients()));
        return 1;
    }

    @Override
    public List<Recipe> selectAllRecipes() {
        return DB;
    }

    @Override
    public Optional<Recipe> selectRecipeById(UUID id) {
        return DB.stream()
                .filter(recipe -> recipe.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteRecipeById(UUID id) {
        Optional<Recipe> recipeMaybe = selectRecipeById(id);
        if(recipeMaybe.isEmpty())
            return 0;
        DB.remove(recipeMaybe.get());
        return 1;
    }

    @Override
    public int updateRecipeById(UUID id, Recipe recipe) {
        return selectRecipeById(id)
                .map(p -> {
                    int indexOfRecipeToUpdate = DB.indexOf(p);
                    if (indexOfRecipeToUpdate >= 0) {
                        DB.set(indexOfRecipeToUpdate, new Recipe(id, recipe.getName(), recipe.getIngredients()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0); //ako selectRecipeById ne pronađe ništa
    }
}
