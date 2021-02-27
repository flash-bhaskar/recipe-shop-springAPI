package com.flash.Recipeshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity	
public class Recipe {
	
	@Id
	@GeneratedValue
	private Long recipeId;
	
	private String name;
	
	private String description;
	
	private String imagePath;
	
	@OneToMany(mappedBy="recipe")
	private Ingredient ingre;
	
	public Recipe() {
		
	}

	public Recipe(Long recipeId, String name, String description, String imagePath, Ingredient ingre) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		this.ingre = ingre;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Ingredient getIngre() {
		return ingre;
	}

	public void setIngre(Ingredient ingre) {
		this.ingre = ingre;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", name=" + name + ", description=" + description + ", imagePath="
				+ imagePath + ", ingre=" + ingre + "]";
	}

	

}
