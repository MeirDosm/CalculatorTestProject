package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "powData")
    public Object[][] powData() {
        return new Object[][]{
                {2.0, 3.0, 8.0},
                {2.0, 3.5, 8.0},
                {5.0, 0.9, 1.0}
        };
    }

    @Test(dataProvider = "powData")
    public void testPow(double base, double exponent, double expected) {
        double result = calculator.pow(base, exponent);
        Assert.assertEquals(result, expected, 0.0001);
    }
}