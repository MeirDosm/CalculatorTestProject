package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "subLongData")
    public Object[][] subLongData() {
        return new Object[][]{
                {5L, 3L, 2L},
                {10L, 4L, 6L},
                {0L, 5L, -5L},
                {-3L, -2L, -1L},
                {-5L, 3L, -8L}
        };
    }

    @Test(groups = {"basic"}, dataProvider = "subLongData")
    public void testSubLong(long a, long b, long expected) {
        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "subDoubleData")
    public Object[][] subDoubleData() {
        return new Object[][]{
                {5.5, 3.2, 2.3},
                {10.0, 4.5, 5.5},
                {0.0, 5.0, -5.0},
                {-3.5, -2.5, -1.0},
                {-5.5, 3.0, -8.5}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "subDoubleData")
    public void testSubDouble(double a, double b, double expected) {
        double result = calculator.sub(a, b);
        Assert.assertEquals(result, expected, 0.0001);
    }
}