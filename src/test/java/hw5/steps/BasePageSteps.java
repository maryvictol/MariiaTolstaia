package hw5.steps;

import hw5.enums.UserCredentials;
import hw5.voids.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BasePageSteps {
    protected WebDriver driver;
    protected BasePage basePage;

    @Step("Login as User")
    public void login(UserCredentials user) {
        basePage.login(user);
    }

    @Step("Check Browser Title")
    public void checkBrowserTitle(String expectTitle){
        assertThat(basePage.getBrowserTitle(), equalTo(expectTitle));
    }

    @Step("Check Left Panel User Name")
    public void checkLeftPanelUserName(String expectTitle){
        assertThat(basePage.getLeftPanelUserName(), equalTo(expectTitle));
    }

    @Step("Check Menu Header Section Items")
    public void checkMenuHeaderSectionItems (List<String> expectListElement) {
        checkListOfTextElements(basePage.getMenuHeaderSectionItems(),expectListElement);
    }

    @Step("Check Text on Page")
    public void checkTextOnPage(WebElement actualText, String expectText) {
        assertThat(actualText.isDisplayed(), is(true));
        assertThat(actualText.getText(), equalTo(expectText));
    }

    @Step("Check Left Panel is Displayed")
    public void checkLeftPanelIsDisplayed() {
        assertThat(basePage.getLeftPanel().isDisplayed(), is(true));
    }

    @Step("Check Footer is Displayed")
    public void checkFooter() {
        assertThat("",basePage.getFooter().isDisplayed());
    }

    @Step("Check Contains List Top Service DropDown Options")
    public void checkContainsListTopServiceDropDownOptions(List<String> expectListElements){
        checkContainListOfElements(basePage.getTopServiceDropDownOptions(), expectListElements);
    }

    @Step("Check Contains List Left Service DropDown Options")
    public void checkContainsListLeftServiceDropDownOptions(List<String> expectListElements){
        checkContainListOfElements(basePage.getLeftServiceDropDownOptions(), expectListElements);
    }

    @Step("Open Different Elements Page")
    public  void openDifferentElementsPage(){
        basePage.openDifferentElementsTab();
    }

    @Step("Check List of Text Elements")
    public void checkListOfTextElements(List<WebElement> elements, List<String> expectListElements) {
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, equalTo(expectListElements));
    }

    @Step("Check Contain List of Elements")
    public void checkContainListOfElements(List<WebElement> elements, List<String> expectListElements) {
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertThat(listElements,hasItems(in(expectListElements)));
    }
}
