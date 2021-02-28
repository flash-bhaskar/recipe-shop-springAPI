package com.flash.Recipeshop.service;

import java.util.List;
import java.util.Optional;

import com.flash.Recipeshop.entity.Recipe;

public interface RecipeInterface {

	Recipe addRecipe(Recipe recipe);

	List<Recipe> getAllRecipe();

	Optional<Recipe> getRecipeById(int id);
	
	void deleteRecipe(int id);
	
	Recipe updateRecipe(int id, Recipe recipe);

}
