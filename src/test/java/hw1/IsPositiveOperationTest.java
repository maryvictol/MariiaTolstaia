package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsPositiveOperationTest {

    private Calculator calculator;

    @BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {1, true},
                {0, false},
                {-100, false}
        };
    }

    @Test(dataProvider = "testData")
    public void testIsPositive(long a, boolean expect) {
        boolean actual = calculator.isPositive(a);
        assertEquals(actual, expect);
    }
}
