package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.testng.Assert.assertEquals;

public class DivOperationTest {

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
                {1, 1, 1},
                {1, -1, -1},
                {-100, 11, -9}
        };
    }

    @Test(dataProvider = "testLongData")
    public void testDivForLong(long a, long b, long expect) {
        long actual = calculator.div(a,b);
        assertEquals(actual, expect);
    }

    @DataProvider
    public Object[][] testDoubleData() {
        return new Object[][]{
                {1.1, 1.1, 1.0},
                {100, -0.25, -400.0},
                {-62.72, 11.2, -5.6},
                {0, 11, 0.0}
        };
    }

    @Test(dataProvider = "testDoubleData")
    public void testDivForDouble(double a, double b, double expect) {
        double actual = calculator.div(a,b);
        // TODO Why do you use BigDecimal?
        assertEquals(new BigDecimal(actual).setScale(2, RoundingMode.HALF_UP),
                     new BigDecimal(expect).setScale(2, RoundingMode.HALF_UP));
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testDevisionToZero() {
        calculator.div(2,0);
    }
}