package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultOperationTest extends BaseTest {

    // TODO IMHO it will be better extract this field to the base class
    //private Calculator calculator;

    // TODO IMHO it will be better extract this hook to the base class
    // TODO Why do you decide use BeforeTestHook?
    /*@BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }*/

    @DataProvider
    public Object[][] testLongData() {
        return new Object[][]{
                {1, 0, 0},
                {1, -1, -1},
                {-100, -11, 1100}
        };
    }

    @Test(dataProvider = "testLongData")
    public void testMultForLong(long a, long b, long expect) {
        long actual = calculator.mult(a,b);
        assertEquals(actual, expect);
    }

    @DataProvider
    public Object[][] testDoubleData() {
        return new Object[][]{
                {1.5, 0, 0},
                {1.5, -1.5, -3.0},
                {-100, 0.011, -2.0},
                {20.5, 11, 225.0}
        };
    }

    @Test(dataProvider = "testDoubleData")
    public void testMultForDouble(double a, double b, double expect) {
        double actual = calculator.mult(a,b);
        assertEquals(actual, expect);
    }
}
