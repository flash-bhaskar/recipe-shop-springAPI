package com.flash.Recipeshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recipes")
public class Recipe {

	@Id
	@GeneratedValue
	private int recipeId;

	@NotEmpty(message = "Username is Mandatory field. Please provide username")
	@Size(min=2, message="Recipe name should be minimum of 2 charchters")
	@Column(unique=false, nullable=false)
	private String name;

	@NotEmpty(message = "Recipe Description is Mandatory field. Please provide recipe description")
	@Size(min=10, message="Recipe name should be minimum of 10 charchters")
	@Column(nullable=false)
	private String description;

	@NotEmpty(message = "Image is Mandatory field. Please provide imagepath")
	@Column(nullable=false)
	private String imagePath;

	@OneToMany(mappedBy = "recipe", cascade=CascadeType.ALL)
	private List<Ingredient> ingredients;

	public Recipe() {

	}

	public Recipe(int recipeId, String name, String description, String imagePath, List<Ingredient> ingredients) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		this.ingredients = ingredients;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
