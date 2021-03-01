package com.flash.Recipeshop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.flash.Recipeshop.Exceptions.RecipeExistsException;
import com.flash.Recipeshop.Exceptions.RecipeNotFoundException;
import com.flash.Recipeshop.entity.Recipe;
import com.flash.Recipeshop.service.RecipeService;

@RestController
@Validated
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@GetMapping("/recipes")
	public List<Recipe> getRecipes() {
		try {
			return recipeService.getAllRecipe();
		} catch (RecipeNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/recipes/{id}")
	public Optional<Recipe> getRecipeById(@PathVariable @Min(1) int id) {
		try {
			return recipeService.getRecipeById(id);
		} catch (RecipeNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping("/recipes")
	public ResponseEntity<Void> addRecipe(@Valid @RequestBody Recipe recipe,UriComponentsBuilder builder) {
		try {
			recipeService.addRecipe(recipe);
			HttpHeaders header=new HttpHeaders();
			header.setLocation(builder.path("/recipes/{id}").buildAndExpand(recipe.getRecipeId()).toUri());
			return new ResponseEntity<Void>(header,HttpStatus.CREATED);
			
		} catch (RecipeExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@DeleteMapping("/recipes/{id}")
	public void deleteRecipe(@PathVariable @Min(1) int id) {
		try {
			recipeService.deleteRecipe(id);
		} catch (RecipeNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PutMapping("/recipes/{id}")
	public Recipe updateRecipe(@PathVariable @Min(1) int id, @Valid @RequestBody Recipe recipe) {
		try {
			return recipeService.updateRecipe(id, recipe);
		} catch (RecipeNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
