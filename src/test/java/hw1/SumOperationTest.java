package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SumOperationTest {

    // TODO IMHO it will be better extract this field to the base class
    private Calculator calculator;

    // TODO IMHO it will be better extract this hook to the base class
    // TODO Why do you decide use BeforeTestHook?
    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] testLongData() {
        return new Object[][]{
                {1, 0, 1}, {1, -1, 0}, {-100, -11, -111} };
    }

    @Test(dataProvider = "testLongData")
    public void testSumForLong(long a, long b, long expect) {
        long actual = calculator.sum(a,b);
        assertEquals(actual, expect);
    }

    @DataProvider
    public Object[][] testDoubleData() {
        return new Object[][]{
                {1.52, 0.368, 1.888}, {1.5, -1.5, 0.0}, {-100, -0.011, -100.011}, {20.5, 0.0, 20.5} };
    }

    @Test(dataProvider = "testDoubleData")
    public void testSumForDouble(double a, double b, double expect) {
        double actual = calculator.sum(a,b);
        assertEquals(actual, expect);
    }

}
