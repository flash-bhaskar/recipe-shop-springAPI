package com.flash.Recipeshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flash.Recipeshop.entity.Ingredient;
import com.flash.Recipeshop.entity.Recipe;
import com.flash.Recipeshop.repository.IngredientRepository;
import com.flash.Recipeshop.repository.RecipeRepository;

@Service
public class RecipeService implements RecipeInterface {

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe addRecipe(Recipe recipe) {
		for (Ingredient ingre : recipe.getIngredients()) {
			ingre.setRecipe(recipe);
		}
		recipe.setIngredients(recipe.getIngredients());

		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAllRecipe() {

		return recipeRepository.findAll();
	}

	@Override
	public Optional<Recipe> getRecipeById(int id) {

		return recipeRepository.findById(id);

	}

	@Override
	public void deleteRecipe(int id) {
		recipeRepository.deleteById(id);
	}

	@Override
	public Recipe updateRecipe(int id, Recipe recipe) {
		for (Ingredient ingre : recipe.getIngredients()) {
			ingre.setRecipe(recipe);
		}
		recipe.setIngredients(recipe.getIngredients());
		recipe.setRecipeId(id);

		return recipeRepository.save(recipe);
	}

}
