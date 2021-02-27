package com.flash.Recipeshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flash.Recipeshop.entity.Recipe;
import com.flash.Recipeshop.repository.RecipeRepository;

public class RecipeService implements RecipeInterface {

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe addRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAllRecipe() {
		
		return recipeRepository.findAll();
	}

	@Override
	public Recipe getRecipeById(int id) {
	
		Recipe recipe= recipeRepository.findById((long) id).get();
		return recipe;
	}

	

}
