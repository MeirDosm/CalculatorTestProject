import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class AddTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "sumLongData")
    public Object[][] sumLongData() {
        return new Object[][]{
                {1L, 2L, 3L},
                {0L, 0L, 0L},
                {-5L, -3L, -8L},
                {10L, -5L, 5L}
        };
    }

    @Test(groups = {"basic"}, dataProvider = "sumLongData")
    public void testSumLong(long a, long b, long expected) {
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, expected);
    }
}