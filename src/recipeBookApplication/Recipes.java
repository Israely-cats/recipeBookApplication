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
    private String difficultyLevel;
    private int cookingTime;
    
    public Recipes (String name, List<String>ingredients, String instructions,String cuisine, String mealType) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.mealType = mealType;
        this.difficultyLevel = difficultyLevel;
        this.cookingTime = cookingTime;
    }
    
    public int getCookingTime() {
		return cookingTime;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
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
        System.out.println("Cuisine: " + cuisine + " | Meal Type: " + mealType + " | Difficulty: " + difficultyLevel);
        System.out.println("Cooking Time: " + cookingTime + " minutes");
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Instructions: " + instructions);
    }
    
}
