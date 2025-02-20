package recipeBookApplication;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import recipeBookApplication.*;

public class RecipesManagement extends Recipes implements Serializable {
    RecipesManagement() {
        super();
    }

    public RecipesManagement(String name, List<String> ingredients, String instructions, String cuisine,
            String mealType, String difficultyLevel, int cookingTime) {
        super(name, ingredients, instructions, cuisine, mealType, difficultyLevel, cookingTime);

    }

    public static List<RecipesManagement> recipes = new ArrayList<>();

    public void addRecipe() { // Method to Add Recipe
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of ingredients: ");
        int numIngredients = scanner.nextInt();
        scanner.nextLine();

        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < numIngredients; i++) {
            System.out.print("Enter ingredient " + (i + 1) + ": ");
            ingredients.add(scanner.nextLine());
        }

        System.out.print("Enter cooking instructions: ");
        String instructions = scanner.nextLine();

        System.out.print("Enter Cuisine (e.g., Italian, Mexican): ");
        String cuisine = scanner.nextLine();

        System.out.print("Enter Meal Type (e.g., Breakfast, Lunch, Dinner): ");
        String mealType = scanner.nextLine();

        System.out.print("Enter Difficulty Level (Easy, Medium, Hard): ");
        String difficultyLevel = scanner.nextLine();

        System.out.print("Enter Cooking Time (in minutes): ");
        int cookingTime = scanner.nextInt();
        scanner.nextLine();

        recipes.add(new RecipesManagement(name, ingredients, instructions, difficultyLevel, mealType, cuisine,
                cookingTime));
        System.out.println("Recipe added successfully!");
    }

    public void displayRecipes() { // Method to Display Recipes
        if (recipes.isEmpty()) {
            System.out.printf("No recipes available.\n\r");
        } else {
            for (RecipesManagement recipe : recipes) {
                recipe.displayRecipe();
            }
        }
    }

    public static void searchByCuisine() { // Method to Search by Cuisine
        System.out.print("Enter Cuisine to Search: ");
        Scanner scanner = new Scanner(System.in);
        String selectedCuisine = scanner.nextLine();

        System.out.println("\n\r🔎 Recipes under " + selectedCuisine + " Cuisine:");
        for (RecipesManagement recipe : recipes) {
            if (recipe.getCuisine().equalsIgnoreCase(selectedCuisine)) {
                recipe.displayRecipe();
            }
        }
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchByMealType() { // Method to Search by Meal Type
        System.out.print("Enter Meal Type to Search: ");
        Scanner scanner = new Scanner(System.in);
        String selectedMealType = scanner.nextLine();

        System.out.println("\n\r🔎 Recipes under " + selectedMealType + " Meal Type:");
        for (RecipesManagement recipe : recipes) {
            if (recipe.getMealType().equalsIgnoreCase(selectedMealType)) {
                recipe.displayRecipe();
            }
        }
    }

    public static void searchByCookingTime() { // Method to Search by cooking time
        System.out.print("Enter Maximum Cooking Time (in minutes): ");
        Scanner scanner = new Scanner(System.in);
        int maxTime = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n\r🔎 Recipes under " + maxTime + " minutes:");
        for (RecipesManagement recipe : recipes) {
            if (recipe.getCookingTime() <= maxTime) {
                recipe.displayRecipe();
            }
        }
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchByIngredients() { // Method to Search by ingredients
        System.out.print("Enter ingredient to search for: ");
        Scanner scanner = new Scanner(System.in);
        String ingredient = scanner.nextLine().toLowerCase();

        System.out.println("\n\r🔎 Recipes containing " + ingredient + ":");
        for (RecipesManagement recipe : recipes) {
            for (String ing : recipe.getIngredients()) {
                if (ing.toLowerCase().contains(ingredient)) {
                    recipe.displayRecipe();
                    break;
                }
            }
        }
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void filterByMealType() { // Method to Filter by Meal type
        System.out.print("Enter Meal Type to filter (e.g., Breakfast, Lunch, Dinner): ");
        Scanner scanner = new Scanner(System.in);
        String selectedMealType = scanner.nextLine();

        System.out.println("\n\r Recipes under " + selectedMealType + " Meal Type:");
        for (RecipesManagement recipe : recipes) {
            if (recipe.getMealType().equalsIgnoreCase(selectedMealType)) {
                recipe.displayRecipe();
            }
        }
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void filterByDifficulty() { // Method to Filter by difficulty
        System.out.print("Enter Difficulty Level to filter (Easy, Medium, Hard): ");
        Scanner scanner = new Scanner(System.in);
        String selectedDifficulty = scanner.nextLine();

        System.out.println("\n\r Recipes with " + selectedDifficulty + " Difficulty:");
        for (RecipesManagement recipe : recipes) {
            if (recipe.getDifficultyLevel().equalsIgnoreCase(selectedDifficulty)) {
                recipe.displayRecipe();
            }
        }
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editRecipe() { // Method to Edit Recipe
        Scanner scanner = new Scanner(System.in);
        displayRecipes();
        if (recipes.isEmpty())
            return;

        System.out.print("Enter the recipe number to edit: ");
        int recipeIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (recipeIndex >= 0 && recipeIndex < recipes.size()) {
            RecipesManagement recipe = recipes.get(recipeIndex);

            System.out.println("Editing Recipe:" + getName());
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                recipe.setName(newName);

                System.out.print("Do you want to edit ingredients? (yes/no): ");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    List<String> newIngredients = new ArrayList<>();
                    System.out.print("Enter number of ingredients: ");
                    int numIngredients = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numIngredients; i++) {
                        System.out.print("Enter ingredient " + (i + 1) + ": ");
                        newIngredients.add(scanner.nextLine());
                    }
                    recipe.setIngredients(newIngredients);
                }

                System.out.print("Enter new instructions (or press Enter to keep the same): ");
                String newInstructions = scanner.nextLine();
                if (!newInstructions.isEmpty()) {
                    recipe.setInstructions(newInstructions);
                }

                System.out.println("Recipe updated successfully!");
            } else {
                System.out.println("Invalid recipe number.");
            }
        }
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecipe() { // Method to Delete Recipe
        Scanner scanner = new Scanner(System.in);
        displayRecipes();

        if (recipes.isEmpty())
            return;

        System.out.print("Enter the recipe number to delete: ");
        int recipeIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (recipeIndex >= 0 && recipeIndex < recipes.size()) {
            System.out.println("Deleting Recipe: " + recipes.get(recipeIndex).getName());
            recipes.remove(recipeIndex);
            System.out.println("Recipe deleted successfully!");
        } else {
            System.out.println("Invalid recipe number.");
        }
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
