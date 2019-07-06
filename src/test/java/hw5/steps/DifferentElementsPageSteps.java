package hw5.steps;

import hw5.TestProvider;
import hw5.voids.BasePage;
import hw5.voids.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DifferentElementsPageSteps extends BasePageSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        super.driver = driver;
        TestProvider.getInstance().setDriver(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        basePage = new BasePage(driver);
    }

    @Step("Assert Check Boxes Size")
    public void assertCheckBoxesSize(int count) {
        assertThat(differentElementsPage.getCheckBoxes().size(), is(count));
    }

    @Step("Assert Radio Buttons Size")
    public void assertRadioButtonsSize(int count) {
        assertThat(differentElementsPage.getRadioButtons().size(), is(count));
    }

    @Step("Assert Color DropDown is Displayed")
    public void assertColorDropDownIsDisplayed() {
        assertThat("",differentElementsPage.getColorDropDown().isDisplayed());
    }

    @Step("Assert Default Button is Displayed")
    public void assertDefaultButtonIsDisplayed() {
        assertThat("",differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Step("Assert Button is Displayed")
    public void assertButtonIsDisplayed() {
        assertThat("",differentElementsPage.getButton().isDisplayed());
    }

    @Step("Assert Right Panel is Displayed")
    public void assertRightPanelIsDisplayed() {
//        TODO assertThat(differentElementsPage.getRightPanel().isDisplayed());
        assertThat("",differentElementsPage.getRightPanel().isDisplayed());
    }

    @Step("Mark Required Check Boxes")
    public void markRequiredCheckBoxes(List<String> expectCheckboxes){
        markRequiredBoxes(differentElementsPage.getCheckBoxes(), expectCheckboxes);
    }

    @Step("Mark Required Radio Buttons")
    public void markRequiredRadioButtons(List<String> expectRadioButtons){
        markRequiredBoxes(differentElementsPage.getRadioButtons(), expectRadioButtons);
    }

    @Step("Select Required Color")
    public void selectRequiredColor(String color) {
        new Select(differentElementsPage.getColorDropDownOptions())
                .selectByVisibleText(color);
    }

    @Step("Mark Required Boxes")
    public void markRequiredBoxes(List<WebElement> checkBoxesList, List<String> expectCheckboxes) {
        for (String expectCheck : expectCheckboxes) {
            for (WebElement checkBox : checkBoxesList) {
                if (checkBox.getText().equals(expectCheck)) {
                    checkBox.click();
                    break;
                }
            }
        }
    }

    @Step("Check Log Records")
    public void checkLogRecords(String expect) {
        List<String> listElements = differentElementsPage.getLogRowsList()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, hasItem(endsWith(expect)));
    }
}
