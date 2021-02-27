package com.flash.Recipeshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue
	private Long ingreDientId;

	private String name;
	
	private Integer amount;
	
	@ManyToOne
	private Recipe recipe;
	
	
	public Ingredient() {
		
	}


	public Ingredient(Long ingreDientId, String name, Integer amount, Recipe recipe) {
		super();
		this.ingreDientId = ingreDientId;
		this.name = name;
		this.amount = amount;
		this.recipe = recipe;
	}


	public Long getIngreDientId() {
		return ingreDientId;
	}


	public void setIngreDientId(Long ingreDientId) {
		this.ingreDientId = ingreDientId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	

	
}
