package hw3.steps;

import hw3.enums.UserCredentials;
import hw3.voids.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BasePageSteps {
    protected WebDriver driver;
    protected BasePage basePage;

    // TODO Could be protected
    // TODO I guess you forgot parameter WebDriver driver here? :)
    public BasePageSteps() {
        this.driver = driver;
    }

    public void login(UserCredentials user) {
        basePage.login(user);
    }

    public void assertBrowserTitle (String expectTitle){
        assertThat(basePage.getBrowserTitle(), equalTo(expectTitle));
    }

    // TODO assertLeftPanelUserName
    public void assertleftPanelUserName (String expectTitle){
        assertThat(basePage.getleftPanelUserName(), equalTo(expectTitle));
    }

    public void checkMenuHeaderSectionItems (List<String> expectListElement) {
        checkListOfTextElements(basePage.getMenuHeaderSectionItems(),expectListElement);
    }

    public void checkTextOnPage(WebElement actualText, String expectText) {
        assertThat(actualText.isDisplayed(), is(true));
        assertThat(actualText.getText(), equalTo(expectText));
    }

    public void checkLeftPanelIsDisplayed() {
        assertThat(basePage.getLeftPanel().isDisplayed(), is(true));
    }

    public void checkFooter() {
        assertThat(basePage.getFooter().isDisplayed(), is(true));
    }

    public void checkContainsListTopServiceDropDownOptions(List<String> expectListElements){
        checkContainListOfElements(basePage.getTopServiceDropDownOptions(), expectListElements);
    }

    public void checkContainsListLeftServiceDropDownOptions(List<String> expectListElements){
        checkContainListOfElements(basePage.getLeftServiceDropDownOptions(), expectListElements);
    }

    public  void openDifferentElementsPage(){
        basePage.openDifferentElementsTab();
    }


    public void checkListOfTextElements(List<WebElement> elements, List<String> expectListElements) {
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, equalTo(expectListElements));
    }

    public void checkContainListOfElements(List<WebElement> elements, List<String> expectListElements) {
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertThat(listElements,hasItems(in(expectListElements)));
    }
}
