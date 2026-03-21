package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "sinDoubleData")
    public Object[][] sinDoubleData() {
        return new Object[][]{
                {0.0, 0.0},
                {Math.PI / 2, 1.0},
                {Math.PI, 0.0},
                {3 * Math.PI / 2, -1.0},
                {-Math.PI / 2, -1.0}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "sinDoubleData")
    public void testSinDouble(double angle, double expected) {
        double result = calculator.sin(angle);
        Assert.assertEquals(result, expected, 0.0001);
    }
}
