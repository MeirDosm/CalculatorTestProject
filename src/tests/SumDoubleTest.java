import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class SumDoubleTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "sumDoubleData")
    public Object[][] sumDoubleData() {
        return new Object[][]{
                {1.5, 2.5, 4.0},
                {0.1, 0.2, 0.3},
                {-1.5, -2.5, -4.0},
                {10.0, -5.0, 5.0}
        };
    }

    @Test(groups = {"advanced"}, dataProvider = "sumDoubleData")
    public void testSumDouble(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        Assert.assertEquals(result, expected, 0.0001);
    }
}