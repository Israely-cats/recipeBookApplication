package recipeBookApplication;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // List<String> strings = List<String>("Some", "else", "other");
        List<String> strings = Arrays.asList(new String[]{"Some", "else", "other"});
        RecipesManagement manager = new RecipesManagement("some", strings, "Maybe", "no", "yesa");
        manager.displayRecipe();
        manager.addRecipe();
        manager.displayRecipe();
    }
}
