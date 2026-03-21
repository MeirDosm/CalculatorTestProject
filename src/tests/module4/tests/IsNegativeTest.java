package module4.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    // ----------------- LONG NEGATIVE TESTS -----------------
    @DataProvider(name = "isNegativeLongData")
    public Object[][] isNegativeLongData() {
        return new Object[][]{
                {5L, false},
                {0L, false},
                {-3L, true},
                {-100L, true},
                {100L, false}
        };
    }

    @Test(groups = {"basic"}, dataProvider = "isNegativeLongData")
    public void testIsNegativeLong(long value, boolean expected) {
        boolean result = calculator.isNegative(value);
        Assert.assertEquals(result, expected);
    }
}