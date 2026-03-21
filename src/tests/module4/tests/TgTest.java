package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "tgDoubleData")
    public Object[][] tgDoubleData() {
        return new Object[][]{
                {0.0, 0.0},
                {Math.PI / 3, Math.sqrt(3)},
                {Math.PI / 4, 1.0},
                {-Math.PI / 4, -1.0},
                {-Math.PI / 3, -Math.sqrt(3)}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "tgDoubleData")
    public void testTgDouble(double input, double expected) {
        double result = calculator.tg(input);
        Assert.assertEquals(result, expected, 0.0001);
    }
}