package recipeBookApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recipes {

	private String name;
    private List<String> ingredients;
    private String instructions;
    private String cuisine;
    private String mealType;
    
    public Recipes (String name, List<String>ingredients, String instructions,String cuisine, String mealType) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.mealType = mealType;
    }
    
    public String getName() {
		return name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void displayRecipe() {
        System.out.println("Recipe Name: " + name);
        System.out.println("Cuisine: " + cuisine + " | Meal Type: " + mealType);
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Instructions: " + instructions);
    }
    
}
