import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Сдобная", 30);

    @Test
    public void getNameBunTest() {
        String expectedBunName = "Сдобная";
        String actualBunName = bun.getName();
        Assert.assertEquals(expectedBunName, actualBunName);
    }

    @Test
    public void getPriceBunTest() {
        float expectedBunPrice = 30;
        float actualBunPrice = bun.getPrice();
        Assert.assertEquals(expectedBunPrice, actualBunPrice, 0);
    }
}