import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    @Test
    public void availableBunsTest() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertEquals("Видов булок различно", 3, buns.size());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals("Видов ингридиентов различно", 6, ingredients.size());
    }
}
