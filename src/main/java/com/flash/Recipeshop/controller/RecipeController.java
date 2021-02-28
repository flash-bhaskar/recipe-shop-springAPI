package com.flash.Recipeshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flash.Recipeshop.entity.Recipe;
import com.flash.Recipeshop.service.RecipeService;

@RestController
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("/recipes")
	public List<Recipe> getRecipes(){
		return recipeService.getAllRecipe();
	}
	
	@GetMapping("/recipes/{id}")
	public Optional<Recipe> getRecipeById(@PathVariable int id) {
		return recipeService.getRecipeById(id);
	}
	
	@PostMapping("/recipes")
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		return recipeService.addRecipe(recipe);
	}
	
	@DeleteMapping("/recipes/{id}")
	public void deleteRecipe(@PathVariable int id) {
		recipeService.deleteRecipe(id);
	}
	
	@PutMapping("/recipes/{id}")
	public Recipe updateRecipe(@PathVariable int id,@RequestBody Recipe recipe) {
		return recipeService.updateRecipe(id, recipe);
	}

}
