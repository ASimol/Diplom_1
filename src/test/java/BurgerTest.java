import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;


    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Нет булочки!", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        assertEquals("Ингридиента нет!", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        assertEquals("Первый ингридент не удален!", 0, burger.ingredients.size());
    }

    @Test
    public void removeAllIngredientsTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        assertEquals("Ингридиенты не удалены", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        ingredientOne = new Ingredient(SAUCE, "Кетчуп", 20);
        ingredientTwo = new Ingredient(FILLING, "Салат", 30);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        assertEquals("Ингридиенты не переместились", ingredientOne.name, burger.ingredients.get(1).name);
        assertEquals("Ингридиенты не переместились", ingredientTwo.name, burger.ingredients.get(0).name);
    }

    @Test
    public void getPriceWithoutIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(30F);
        assertEquals("Цена должна быть 60", 30 * 2, burger.getPrice(), 0);
    }

    @Test
    public void getPriceWithIngredientTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        float expectedPrice = 110F;
        Mockito.when(bun.getPrice()).thenReturn(30F);
        Mockito.when(ingredientOne.getPrice()).thenReturn(20F);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(30F);
        Assert.assertEquals("Цена бургера не верна!", expectedPrice, burger.getPrice(), 0);
    }
    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        Mockito.when(bun.getName()).thenReturn("Сдобная");
        Mockito.when(ingredientOne.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientOne.getName()).thenReturn("Кетчуп");
        Mockito.when(burger.getPrice()).thenReturn(80F);
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Сдобная"));
        expectedReceipt.append(String.format("= %s %s =%n", "sauce", "Кетчуп"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "Сдобная"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 80F));
        assertEquals("Ошибка в рецепте!", expectedReceipt.toString(), burger.getReceipt());
    }
}
