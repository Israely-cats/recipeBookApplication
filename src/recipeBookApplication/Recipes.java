package recipeBookApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;
import recipeBookApplication.*;

public class Recipes implements Serializable {

    private String name;
    private List<String> ingredients;
    private String instructions;
    private String cuisine;
    private String mealType;
    private String difficultyLevel;
    private int cookingTime;

    Recipes() {
        return;
    }

    public Recipes(String name, List<String> ingredients, String instructions, String cuisine, String mealType,
            String difficultyLevel, int cookingTime) {
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
        System.out.print("Recipe Name: " + name);
        System.out.print("\n\r");
        System.out.print("Cuisine: " + cuisine + " | Meal Type: " + mealType + " | Difficulty: " + difficultyLevel);
        System.out.print("\n\r");
        System.out.print("Cooking Time: " + cookingTime + " minutes");
        System.out.print("\n\r");
        System.out.print("Ingredients: " + ingredients);
        System.out.print("\n\r");
        System.out.print("Instructions: " + instructions);
        System.out.print("\n\r");
    }
}
