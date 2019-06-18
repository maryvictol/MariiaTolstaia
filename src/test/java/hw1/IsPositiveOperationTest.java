package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsPositiveOperationTest extends BaseTest {

    // TODO IMHO it will be better extract this field to the base class
    //private Calculator calculator;

    // TODO IMHO it will be better extract this hook to the base class
    // TODO Why do you decide use BeforeTestHook?
    /*@BeforeTest
    public void initialization() {
        calculator = new Calculator();
    }*/

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
