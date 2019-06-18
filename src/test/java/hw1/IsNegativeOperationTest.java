package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsNegativeOperationTest extends BaseTest {

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
                {1, false},
                {0, false},
                {-100, true}
        };
    }

    @Test(dataProvider = "testData")
    public void testIsNegative(long a, boolean expect) {
        boolean actual = calculator.isNegative(a);
        assertEquals(actual, expect);
    }
}
