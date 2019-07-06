package hw5.steps;

import hw5.voids.BasePage;
import hw5.voids.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class HomePageSteps extends BasePageSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        super.driver = driver;
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
    }

    @Step("Check Displayed List of Images Elements")
    public void checkDisplayedListOfImagesElements(int expectElementsNumber){
        List<WebElement> elements = homePage.getImagesOnIndexPage();
        assertThat(elements.size(), equalTo(expectElementsNumber));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement icon : elements) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Step("Check Iframe is Displayed")
    public void checkIframeIsDisplayed(){
        assertThat("",homePage.getIframe().isDisplayed());
    }

    @Step("Check List of Text Elements")
    public void checkListOfTextElements(List<String> expectListElements) {
        List<String> listElements = homePage.getTextUnderImagesOnIndexPage()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, equalTo(expectListElements));
    }

    @Step("Check Text First Main Header")
    public void checkTextFirstMainHeader(String expectText) {
        checkTextOnPage(homePage.getFirstMainHeader(), expectText);
    }

    @Step("Check Text Second Main Header")
    public void checkTextSecondMainHeader(String expectText) {
        checkTextOnPage(homePage.getSecondMainHeader(), expectText);
    }

    @Step("Check Text SubHeader")
    public void checkTextSubHeader(String expectText) {
        checkTextOnPage(homePage.getSubHeader(), expectText);
    }

    @Step("Check URL JDI Github Link")
    public void checkURLJdiGithubLink(String expectText) {
        assertEquals(homePage.getSubHeader().getAttribute("href"),expectText);
    }

    @Step("Switch to Frame")
    public void switchToFrame() {
        driver.switchTo().frame(homePage.getIframe());
    }

    @Step("Switch to Original Window Back")
    public void switchToOriginalWindowBack() {
        driver.switchTo().defaultContent();
    }

    @Step("Check Epam Logo is Displayed")
    public void checkEpamLogoIsDisplayed(){
        assertThat("",homePage.getEpamLogo().isDisplayed());
    }
}
