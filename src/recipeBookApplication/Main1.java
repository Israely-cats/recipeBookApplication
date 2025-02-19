package recipeBookApplication;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipesManagement recipeManager = new RecipesManagement("", null, "", "", "", null, 0);

        while (true) {
            try {
                System.out.println("\n Recipe Book Application");
                System.out.println("1️ Add Recipe");
                System.out.println("2️ View Recipes");
                System.out.println("3️ Search by Cuisine");
                System.out.println("4️ Search by Meal Type");
                System.out.println("5️ Search by Ingredients");
                System.out.println("6️ Search by Cooking Time");
                System.out.println("7️ Filter by Meal Type");
                System.out.println("8️ Filter by Difficulty Level");
                System.out.println("9️ Edit Recipe");
                System.out.println("10 Delete Recipe");
                System.out.println("0️ Exit");
                System.out.print("👉 Enter your choice: ");

                // Ensure valid integer input
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        recipeManager.addRecipe();
                        break;
                    case 2:
                        recipeManager.displayRecipes();
                        break;
                    case 3:
                        RecipesManagement.searchByCuisine();
                        break;
                    case 4:
                        RecipesManagement.searchByMealType();
                        break;
                    case 5:
                        RecipesManagement.searchByIngredients();
                        break;
                    case 6:
                        RecipesManagement.searchByCookingTime();
                        break;
                    case 7:
                        RecipesManagement.filterByMealType();
                        break;
                    case 8:
                        RecipesManagement.filterByDifficulty();
                        break;
                    case 9:
                        recipeManager.editRecipe();
                        break;
                    case 10:
                        recipeManager.deleteRecipe();
                        break;
                    case 0:
                        System.out.println("🚀 Exiting Recipe Book Application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println(" Invalid choice! Please enter a number between 0 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Error: Please enter a valid number!");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println(" Unexpected error occurred: " + e.getMessage());
            }
        }
    }
