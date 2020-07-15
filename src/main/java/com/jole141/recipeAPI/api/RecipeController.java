package com.jole141.recipeAPI.api;

import com.jole141.recipeAPI.model.Recipe;
import com.jole141.recipeAPI.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/recipe")
@RestController
@CrossOrigin(origins = "*")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @GetMapping
    public List<Recipe> getAllPeople() {
        return recipeService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Recipe getPersonById(@PathVariable("id") UUID id) {
        return recipeService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePeronById(@PathVariable("id") UUID id) {
        recipeService.deleteRecipe(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody Recipe recipeToUpdate) {
        recipeService.updateRecipe(id, recipeToUpdate);
    }
}
