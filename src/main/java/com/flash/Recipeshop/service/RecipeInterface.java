package com.flash.Recipeshop.service;

import java.util.List;
import java.util.Optional;

import com.flash.Recipeshop.Exceptions.RecipeExistsException;
import com.flash.Recipeshop.Exceptions.RecipeNotFoundException;
import com.flash.Recipeshop.entity.Recipe;

public interface RecipeInterface {

	Recipe addRecipe(Recipe recipe) throws RecipeExistsException;

	List<Recipe> getAllRecipe() throws RecipeNotFoundException;

	Optional<Recipe> getRecipeById(int id) throws RecipeNotFoundException;
	
	void deleteRecipe(int id)throws RecipeNotFoundException;
	
	Recipe updateRecipe(int id, Recipe recipe) throws RecipeNotFoundException;

}
