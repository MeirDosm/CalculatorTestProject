package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "isPositiveLongData")
    public Object[][] isPositiveLongData() {
        return new Object[][]{
                {5L, true},
                {0L, false},
                {-3L, false},
                {100L, true},
                {-100L, false}
        };
    }

    @Test(groups = {"basic"}, dataProvider = "isPositiveLongData")
    public void testIsPositiveLong(long value, boolean expected) {
        boolean result = calculator.isPositive(value);
        Assert.assertEquals(result, expected);
    }
}