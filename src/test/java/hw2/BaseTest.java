package hw2;

import hw2.enums.ConnectConstants;
import hw2.enums.UserCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

// TODO It will be better use only hamcrest assertions in the project if you started using them   - DONE

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                .toAbsolutePath().toString());
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConnectConstants.URL.getData());
    }

    @AfterMethod
    public  void closeDriver(){
        driver.close();
    }

    protected void login(UserCredentials user) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(user.login);
        driver.findElement(By.cssSelector("#password")).sendKeys(user.password);
        driver.findElement(By.id("login-button")).click();
    }

    protected void assertBrowserTitle (String expectTitle){
        assertThat(driver.getTitle(), is(equalTo(expectTitle)));
    }

    protected void checkListOfTextElements(By by, List<String> expectListElements) {
        List<WebElement> elements = driver.findElements(by);
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, is(equalTo(expectListElements)));
    }

    protected void checkDisplayedListOfImagesElements(By by, int expectElementsNumber) {
        List<WebElement> elements = driver.findElements(by);
        // TODO It is better use assertEquals here - DONE
        assertThat(elements.size(), is(equalTo(expectElementsNumber)));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement icon : elements) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        softAssert.assertAll();
    }

    protected void checkTextOnPage(By by, String expectText) {
        WebElement actualText = driver.findElement(by);
        assertThat(actualText.isDisplayed(), is(true));
        assertThat(actualText.getText(), is(equalTo(expectText)));
    }

    protected void checkElementIsDisplayed(By by){
        assertThat(driver.findElement(by).isDisplayed(), is(true));
    }

    protected void checkContainListOfElements(By by, List<String> expectListElements) {
        List<WebElement> elements = driver.findElements(by);
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertThat(listElements,hasItems(in(expectListElements)));
    }

    // TODO Required instead of Requered - DONE
    protected void markRequiredCheckboxes(List<WebElement> checkBoxesList ,List<String> expectCheckboxes){
        /* TODO
            It is better set for (String expectCheck : expectCheckboxes) as first loop
            List of the expectedCheck boxes could be less then checkBoxesList    - DONE
         */
        for (String expectCheck : expectCheckboxes) {
            for (WebElement checkBox : checkBoxesList) {
                if(checkBox.getText().equals(expectCheck)){
                    checkBox.click();
                    // TODO add break after click it is reduce amount of operations    - DONE
                    break;
                }
            }
        }
    }

    protected void checkLogRecord(String expect) {
        List<WebElement> logRowList = driver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        List<String> listElements = logRowList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, hasItem(endsWith(expect)));
    }


}
