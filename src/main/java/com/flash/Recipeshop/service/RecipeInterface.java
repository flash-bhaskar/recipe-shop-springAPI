package com.flash.Recipeshop.service;

import java.util.List;

import com.flash.Recipeshop.entity.Recipe;

public interface RecipeInterface {
	
	Recipe addRecipe(Recipe recipe);
	
	List<Recipe> getAllRecipe();
	
	Recipe getRecipeById(int id);
	
	
	

}
