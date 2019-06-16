package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SqrtOperationTest {

    private Calculator calculator;

    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {1, 1},
                {4.0, 2.0},
                {0.0, 0.0},
                {-9.0, 3.0}
        };
    }

    @Test(dataProvider = "testData")
    public void testSqrt(double a, double expect) {
        double actual = calculator.sqrt(a);
        assertEquals(actual, expect);
    }
}
