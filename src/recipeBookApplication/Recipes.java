package recipeBookApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recipes {

	private String name;
    private List<String> ingredients;
    private String instructions;
    
    public Recipes (String name, List<String>ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
    
    public String getName() {
		return name;
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
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Instructions: " + instructions);
    }
    
}
