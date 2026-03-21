package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "sqrtDoubleData")
    public Object[][] sqrtDoubleData() {
        return new Object[][]{
                {4.0, 2.0},
                {0.0, 0.0},
                {9.0, 3.0},
                {16.0, 4.0},
                {25.0, 5.0}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "sqrtDoubleData")
    public void testSqrtDouble(double a, double expected) {
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, expected, 0.0001);
    }
}