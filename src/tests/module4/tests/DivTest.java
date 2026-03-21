package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "divLongData")
    public Object[][] divLongData() {
        return new Object[][]{
                {10L, 2L, 5L},
                {9L, 3L, 3L},
                {-12L, 4L, -3L},
                {15L, -5L, -3L},
                {0L, 5L, 0L}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "divLongData")
    public void testDivLong(long a, long b, long expected) {
        long result = calculator.div(a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "divDoubleData")
    public Object[][] divDoubleData() {
        return new Object[][]{
                {7.5, 2.5, 3.0},
                {5.0, 2.0, 2.5},
                {-10.0, 2.5, -4.0},
                {15.0, -3.0, -5.0},
                {0.0, 4.0, 0.0}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "divDoubleData")
    public void testDivDouble(double a, double b, double expected) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expected, 0.0001);
    }

        @Test(groups = {"advanced"}, expectedExceptions = NumberFormatException.class)
    public void testDivLongByZero() {
        calculator.div(5L, 0L);
    }
}