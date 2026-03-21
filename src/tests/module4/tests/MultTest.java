package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "multLongData")
    public Object[][] multLongData() {
        return new Object[][]{
                {2L, 3L, 6L},
                {0L, 5L, 0L},
                {-4L, 2L, -8L},
                {-3L, -3L, 9L},
                {10L, -5L, -50L}
        };
    }

    @Test(groups = {"basic"}, dataProvider = "multLongData")
    public void testMultLong(long a, long b, long expected) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expected, "Long multiplication failed for: " + a + " * " + b);
    }

    @DataProvider(name = "multDoubleData")
    public Object[][] multDoubleData() {
        return new Object[][]{
                {2.5, 3.0, 7.0},
                {0.0, 5.0, 0.0},
                {-4.0, 2.5, -10.0},
                {-3.5, -3.0, 10.0},
                {10.0, -5.5, -55.0}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "multDoubleData")
    public void testMultDouble(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expected, 0.0001, "Double multiplication failed for: " + a + " * " + b);
    }
}