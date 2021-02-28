package com.flash.Recipeshop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingredients")
public class Ingredient {

	@Id
	@GeneratedValue
	private int ingredientId;

	private String name;

	private Long amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Recipe recipe;

	public Ingredient() {

	}

	public Ingredient(int ingredientId, String name, Long amount, Recipe recipe) {
		super();
		this.ingredientId = ingredientId;
		this.name = name;
		this.amount = amount;
		this.recipe = recipe;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
