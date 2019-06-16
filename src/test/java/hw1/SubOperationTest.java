package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubOperationTest {

    private Calculator calculator;

    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

   @DataProvider
    public Object[][] testLongData() {
        return new Object[][]{
                {1, 1, 0}, {1, -1, 2}, {-100, 11, -111} };
    }

    @Test(dataProvider = "testLongData")
    public void testSubForLong(long a, long b, long expect) {
        long actual = calculator.sub(a,b);
        assertEquals(actual, expect);
    }

    @DataProvider
    public Object[][] testDoubleData() {
        return new Object[][]{
                {1, 1, 0}, {1, -1, 2}, {-100, 11, -111}, {0, 11, -11}, {100, 0, 100} };
    }

    @Test(dataProvider = "testDoubleData")
    public void testSubForDouble(double a, double b, double expect) {
        double actual = calculator.sub(a,b);
        assertEquals(actual, expect);
    }

}
