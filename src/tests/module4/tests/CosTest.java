package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "cosDoubleData")
    public Object[][] cosDoubleData() {
        return new Object[][]{
                {0.0, 1.0},
                {Math.PI / 2, 0.0},
                {Math.PI, -1.0},
                {3 * Math.PI / 2, 0.0},
                {-Math.PI / 2, 0.0}                };
    }

    @Test(groups = {"basic"}, dataProvider = "cosDoubleData")
    public void testCosDouble(double input, double expected) {
        double result = calculator.cos(input);
        Assert.assertEquals(result, expected, 0.0001);
    }
}