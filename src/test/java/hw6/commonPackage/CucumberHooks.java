package hw6.commonPackage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import hw6.BasePage;
import hw6.DifferentElementsPage;
import hw6.UserTablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestContext.setDriver(driver);
    }

    @After
    public void closeDriver() {
       TestContext.getDriver().close();
        BasePage.clearInstance();
        DifferentElementsPage.clearInstance();
        UserTablePage.clearInstance();
    }



}
