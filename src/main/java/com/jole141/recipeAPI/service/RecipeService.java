package com.jole141.recipeAPI.service;

import com.jole141.recipeAPI.dao.RecipeDao;
import com.jole141.recipeAPI.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeService {

    private  final RecipeDao recipeDao;

    @Autowired
    public RecipeService(@Qualifier("recipeDao") RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public int addRecipe(Recipe recipe) {
        return recipeDao.insertRecipe(recipe);
    }

    public List<Recipe> getAllPeople() {
        return recipeDao.selectAllRecipes();
    }

    public Optional<Recipe> getPersonById(UUID id) {
        return recipeDao.selectRecipeById(id);
    }

    public int deleteRecipe(UUID id) {
        return recipeDao.deleteRecipeById(id);
    }

    public int updateRecipe(UUID id, Recipe newRecipe) {
        return recipeDao.updateRecipeById(id, newRecipe);
    }
}
