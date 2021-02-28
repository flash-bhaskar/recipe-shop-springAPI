package com.flash.Recipeshop.service;

import org.springframework.stereotype.Service;

import com.flash.Recipeshop.entity.Ingredient;
import com.flash.Recipeshop.repository.IngredientRepository;

@Service
public class IngredientService implements IngredientInterface{
	
	private IngredientRepository ingredientRepository;

	@Override
	public Ingredient saveIngredient(Ingredient ingredient) {
	
		return ingredientRepository.save(ingredient);
	}

}
