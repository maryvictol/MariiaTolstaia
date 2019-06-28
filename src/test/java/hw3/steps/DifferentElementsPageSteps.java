package hw3.steps;

import hw3.voids.BasePage;
import hw3.voids.DifferentElementsPage;
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
        differentElementsPage = new DifferentElementsPage(driver);
        basePage = new BasePage(driver);
    }

    public void assertCheckBoxesSize(int count) {
        assertThat(differentElementsPage.getCheckBoxes().size(), is(count));
    }

    public void assertRadioButtonsSize(int count) {
        assertThat(differentElementsPage.getRadioButtons().size(), is(count));
    }

    public void assertColorDropDownIsDisplayed() {
        assertThat(differentElementsPage.getColorDropDown().isDisplayed(), is(true));
    }

    public void assertDefaultButtonIsDisplayed() {
        assertThat(differentElementsPage.getDefaultButton().isDisplayed(), is(true));
    }

    public void assertButtonIsDisplayed() {
        assertThat(differentElementsPage.getButton().isDisplayed(), is(true));
    }

    public void assertRightPanelIsDisplayed() {
        assertThat(differentElementsPage.getRightPanel().isDisplayed(), is(true));
    }

    public void markRequiredCheckBoxes(List<String> expectCheckboxes){
        markRequiredBoxes(differentElementsPage.getCheckBoxes(), expectCheckboxes);
    }

    public void markRequiredRadioButtons(List<String> expectRadioButtons){
        markRequiredBoxes(differentElementsPage.getRadioButtons(), expectRadioButtons);
    }

    public void selectRequiredColor(String color) {
        new Select(differentElementsPage.getColorDropDownOptions())
                .selectByVisibleText(color);
    }

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

    public void checkLogRecords(String expect) {
        List<String> listElements = differentElementsPage.getLogRowsList()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, hasItem(endsWith(expect)));
    }
}
