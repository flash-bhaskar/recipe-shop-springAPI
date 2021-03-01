package com.flash.Recipeshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flash.Recipeshop.Exceptions.RecipeExistsException;
import com.flash.Recipeshop.Exceptions.RecipeNotFoundException;
import com.flash.Recipeshop.entity.Ingredient;
import com.flash.Recipeshop.entity.Recipe;
import com.flash.Recipeshop.repository.RecipeRepository;

@Service
public class RecipeService implements RecipeInterface {

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe addRecipe(Recipe recipe)throws RecipeExistsException {
		//check whether Recipe already exists or not
		Recipe check_recipe=recipeRepository.findByName(recipe.getName());
		if(check_recipe != null) {
			throw new RecipeExistsException("Recipe with name already exists, please choose different name");
		}
		
		//if not exists then add it
		for (Ingredient ingre : recipe.getIngredients()) {
			ingre.setRecipe(recipe);
		}
		//setting the foreign key
		recipe.setIngredients(recipe.getIngredients());

		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAllRecipe() throws RecipeNotFoundException{
		List<Recipe> recipes=recipeRepository.findAll();
		if(recipes.isEmpty()) {
			throw new RecipeNotFoundException("Their are no recipes exists");
		}

		return recipeRepository.findAll();
	}

	@Override
	public Optional<Recipe> getRecipeById(int id) throws RecipeNotFoundException {
		//Checking whether recipe exists or not
		Optional<Recipe> recipe = recipeRepository.findById(id);

		if (!recipe.isPresent()) {
			throw new RecipeNotFoundException("Recipe not Found");
		}

		//if Recipe exists return it
		return recipe;

	}

	@Override
	public void deleteRecipe(int id)throws RecipeNotFoundException{
		//Checking whether recipe exists or not
		Optional<Recipe> recipe = recipeRepository.findById(id);

		if (!recipe.isPresent()) {
			throw new RecipeNotFoundException("Recipe not Found");
		}
		//if Recipe exists then delete it
		recipeRepository.deleteById(id);
	}

	@Override
	public Recipe updateRecipe(int id, Recipe recipe) throws RecipeNotFoundException {
		//Checking whether recipe exists or not
		Optional<Recipe> check_recipe = recipeRepository.findById(id);

		if (!check_recipe.isPresent()) {
			throw new RecipeNotFoundException("Recipe not Found");
		}

		//If Recipe exists update it
		for (Ingredient ingre : recipe.getIngredients()) {
			ingre.setRecipe(recipe);
		}
		//setting the foreign key
		recipe.setIngredients(recipe.getIngredients());
		recipe.setRecipeId(id);

		return recipeRepository.save(recipe);
	}

}
