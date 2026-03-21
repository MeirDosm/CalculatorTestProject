package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CtgTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "ctgDoubleData")
    public Object[][] ctgDoubleData() {
        return new Object[][]{
                {Math.PI / 4, 1.0},
                {Math.PI / 3, 1/Math.sqrt(3)},
                {Math.PI / 6, Math.sqrt(3)},
                {-Math.PI / 4, -1.0},
                {-Math.PI / 3, -1/Math.sqrt(3)}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "ctgDoubleData")
    public void testCtgDouble(double input, double expected) {
        double result = calculator.ctg(input);
        Assert.assertEquals(result, expected, 0.0001);
    }
}