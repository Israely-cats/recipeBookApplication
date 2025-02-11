package recipeBookApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipesManagement extends Recipes {

	public RecipesManagement(String name, List<String> ingredients, String instructions) {
		super(name, ingredients, instructions);
		
	}

	public static List<RecipesManagement> recipes = new ArrayList<>();

    public void addRecipe() {
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

        recipes.add(new RecipesManagement (name, ingredients, instructions));
        System.out.println("Recipe added successfully!");
    }

    

    public void displayRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            for (RecipesManagement recipe : recipes) {
                recipe.displayRecipe();
            }
        }
    }
    
    public void editRecipe() {
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
    }
    
    
    public void deleteRecipe() {
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
    
}
    }
	
