package hw2;

import hw2.ex2.enums.ConnectConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    protected void login(String user, String password) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(user);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    protected void assertBrowserTitle (String expectTitle){
        assertEquals(driver.getTitle(), expectTitle);
    }

    protected void checkListOfTextElements(By by, List<String> expectListElements) {
        List<WebElement> elements = driver.findElements(by);
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(listElements, expectListElements);
    }

    protected void checkDisplayedListOfImagesElements(By by, int expectElementsNumber) {
        List<WebElement> elements = driver.findElements(by);
        assertTrue(elements.size() == expectElementsNumber);
        SoftAssert softAssert = new SoftAssert();
        for (WebElement icon : elements) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        softAssert.assertAll();
    }

    protected void checkTextOnPage(By by, String expectText) {
        WebElement actualText = driver.findElement(by);
        assertTrue(actualText.isDisplayed());
        assertEquals(actualText.getText(), expectText);
    }

    protected void checkElementIsDisplayed(By by, String comment){
        assertTrue(driver.findElement(by).isDisplayed(), comment);
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

    protected void markRequeredCheckboxes(List<WebElement> checkBoxesList ,List<String> expectCheckboxes){
        for (WebElement checkBox : checkBoxesList) {
            for (String expectCheck : expectCheckboxes) {
                if(checkBox.getText().equals(expectCheck)){
                    checkBox.click();
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
