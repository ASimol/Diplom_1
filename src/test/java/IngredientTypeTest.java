import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    IngredientType ingredientType;

    @Parameterized.Parameters
    public static Object[][] getTypes() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "Соус чили", 35);
        assertEquals("Тип не верен!", ingredientType, ingredient.getType());
    }
}
