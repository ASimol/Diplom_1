import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(SAUCE, "Соус чили", 35);

    @Test
    public void getPriseTest() {
        assertEquals("Цена не верна!", 35, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals("Имя не верно!", "Соус чили", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Тип не верный!", SAUCE, ingredient.getType());
    }
}
