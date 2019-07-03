package hw3.steps;

import hw3.voids.BasePage;
import hw3.voids.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class HomePageSteps extends BasePageSteps{

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        super.driver = driver;
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
    }

    public void checkDisplayedListOfImagesElements(int expectElementsNumber){
        List<WebElement> elements = homePage.getImagesOnIndexPage();
        assertThat(elements.size(), equalTo(expectElementsNumber));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement icon : elements) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        softAssert.assertAll();
    }

    // TODO checkIFrameIsDisplayed
    public void checkIframeIsDisplayed(){
        assertThat(homePage.getIframe().isDisplayed(), is(true));
    }

    public void checkListOfTextElements(List<String> expectListElements) {
        List<String> listElements = homePage.getTextUnderImagesOnIndexPage()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, equalTo(expectListElements));
    }

    public void checkTextFirstMainHeader(String expectText) {
        checkTextOnPage(homePage.getFirstMainHeader(), expectText);
    }

    public void checkTextSecondMainHeader(String expectText) {
        checkTextOnPage(homePage.getSecondMainHeader(), expectText);
    }

    public void checkTextSubHeader(String expectText) {
        checkTextOnPage(homePage.getSubHeader(), expectText);
    }

    // TODO String expectText parameter unused here - done
    public void checkURLJdiGithubLink(String expectText) {
        assertEquals(homePage.getSubHeader().getAttribute("href"),expectText);
    }

    public void switchToFrame() {
        driver.switchTo().frame(homePage.getIframe());
    }

    public void switchToOriginalWindowBack() {
        driver.switchTo().defaultContent();
    }

    public void checkEpamLogoIsDisplayed(){
        // TODO It is enough assertThat(homePage.getEpamLogo().isDisplayed());
        assertThat("",homePage.getEpamLogo().isDisplayed());
    }
}
