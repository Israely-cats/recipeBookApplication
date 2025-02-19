package recipeBookApplication;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class RoachUtil {
    static int wrap(int d, int min, int max) {
        final int t = d < min ? max : d;
        return t > max ? min : t;
    }
}

class Menu {
    List<String> options;
    int current;

    Menu() {
        options = new ArrayList<String>();
        current = 0;
    }

    private static void enableRawMode() {
        try {
            new ProcessBuilder("sh", "-c", "stty raw -echo </dev/tty").inheritIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void disableRawMode() {
        try {
            new ProcessBuilder("sh", "-c", "stty sane </dev/tty").inheritIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int runLoop() {
        try {
            // Enable raw mode
            enableRawMode();
            String buffer = "";
            int key = 0;
            while (true) {

                if (key == '\r')
                    break;
                if (key == 65)
                    current--;
                if (key == 66)
                    current++;

                current = RoachUtil.wrap(current, 0, options.size() - 1);

                buffer += "\033[2J";
                buffer += (char) 12;
                for (int i = 0; i < options.size(); i++) {
                    buffer += options.get(i);
                    if (i == current)
                        buffer += " <=";
                    buffer += "\n\r";
                }
                ;

                System.out.printf(buffer);
                key = System.in.read();
                buffer = "";
            }

            System.out.printf("\033[2J");
            System.out.flush();
            disableRawMode();
            return current;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipesManagement recipeManager = new RecipesManagement("", null, "", "", "", null, 0);

        while (true) {
            try {
                Menu menu = new Menu();
                // menu.options.add("\n Recipe Book Application");
                menu.options.add("Add Recipe");
                menu.options.add("View Recipes");
                menu.options.add("Search by Cuisine");
                menu.options.add("Search by Meal Type");
                menu.options.add("Search by Ingredients");
                menu.options.add("Search by Cooking Time");
                menu.options.add("Filter by Meal Type");
                menu.options.add("Filter by Difficulty Level");
                menu.options.add("Edit Recipe");
                menu.options.add("Delete Recipe");
                menu.options.add("Exit");
                // System.out.print("👉 Enter your choice: ");

                int choice = menu.runLoop();
                // Ensure valid integer input
                // int choice = scanner.nextInt();
                // scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 0:
                        recipeManager.addRecipe();
                        break;
                    case 1:
                        recipeManager.displayRecipes();
                        System.out.println("Press enter to continue...");
                        System.in.read();
                        break;
                    case 2:
                        RecipesManagement.searchByCuisine();
                        break;
                    case 3:
                        RecipesManagement.searchByMealType();
                        break;
                    case 4:
                        RecipesManagement.searchByIngredients();
                        break;
                    case 5:
                        RecipesManagement.searchByCookingTime();
                        break;
                    case 6:
                        RecipesManagement.filterByMealType();
                        break;
                    case 7:
                        RecipesManagement.filterByDifficulty();
                        break;
                    case 8:
                        recipeManager.editRecipe();
                        break;
                    case 9:
                        recipeManager.deleteRecipe();
                        break;
                    case 10:
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
}
