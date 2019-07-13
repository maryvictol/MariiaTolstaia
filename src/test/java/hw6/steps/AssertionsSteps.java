package hw6.steps;

import cucumber.api.java.en.Then;
import hw6.commonPackage.TestContext;
import hw6.commonPackage.UserEntity;
import hw6.enums.TestData;

import java.util.List;

import static hw6.enums.DifferentElementsPageConstant.COUNT_CHECKBOXES;
import static hw6.enums.DifferentElementsPageConstant.COUNT_RADIOBUTTONS;
import static hw6.enums.HomePageConstants.*;
import static hw6.enums.UserCredentials.PITER_CHAILOVSKII;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertionsSteps extends BaseStep{

    @Then("'([^\"]+)' page is opened")
    public void checkTitleOpenedPage(String expectTitle) {
        assertThat(TestContext.getDriver().getTitle(), equalTo(expectTitle));
    }

    @Then("Assert User name in the right-top side of screen")
    public void assertUserNameInRightTopSideOfScreen(){
        assertThat(basePage.getTopPanelUserName().getText(),
                equalTo(PITER_CHAILOVSKII.getFullUserName()));
    }

    @Then("Check interface on Home page")
    public void checkInterfaceOnHomePage(){
        checkDisplayedListOfImagesElements(COUNT_IMAGES_ON_HOME_PAGE.getCount());
        checkListOfTextElements(TEXT_ON_INDEX_PAGE_UNDER_ICONS.getItems());
        checkTextFirstMainHeader(FIRST_MAIN_HEADER.getData());
        checkTextSecondMainHeader(SECOND_MAIN_HEADER.getData());
    }

    @Then("Check that there is Right Section")
    public void checkThatThereIsRightSection(){
        assertThat("",differentElementsPage.getRightPanel().isDisplayed());
    }

    @Then("Check that there is Left Section")
    public void checkThatThereIsLeftSection(){
        assertThat("", basePage.getLeftPanel().isDisplayed());
    }

    @Then("Check that top drop down contains options")
    public void checkThatTopDropDownContainsOptions(List<String> expectList){
        checkContainListOfElements(basePage.getTopServiceDropDownOptions(), expectList);
    }

    @Then("Check that left drop down contains options")
    public void checkThatLeftDropDownContainsOptions(List<String> expectList){
        checkContainListOfElements(basePage.getLeftServiceDropDownOptions(), expectList);
    }

    //Different elements Page
    @Then("Check interface on Different elements page")
    public void checkInterfaceOnDifferentElementsPage(){
        assertThat(differentElementsPage.getCheckBoxes().size(), is(COUNT_CHECKBOXES.getCount()));
        assertThat(differentElementsPage.getRadioButtons().size(), is(COUNT_RADIOBUTTONS.getCount()));
        assertThat("",differentElementsPage.getColorDropDown().isDisplayed());
        assertThat("",differentElementsPage.getDefaultButton().isDisplayed());
        assertThat("",differentElementsPage.getButton().isDisplayed());
    }

    @Then("Check that log shows status '([^\"]+)' for '([^\"]+)' checkbox")
    public void checkThatLogShowsCorrectStatusForCheckbox(String status, String checkbox){
        String logResult = checkbox + ": condition changed to " + status;
        checkLogRecords(logResult);
    }

    @Then("Check that log shows that '([^\"]+)' change value to '([^\"]+)'")
    public void checkThatLogShowsThatMetalChangeValue(String element, String radiobutton){
        String logResult = element + ": value changed to " + radiobutton;
        checkLogRecords(logResult);
    }

    //User Table Page
    @Then("'([^\"]+)' NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdownsAreDisplayedOnUserTablePage(TestData expectedCount){
        assertThat(userTablePage.getTypeDropdowns().size(),
                equalTo(expectedCount.getCount()));
    }

    @Then("'([^\"]+)' User names are displayed on Users Table on User Table Page")
    public void checkUserNamesAreDisplayedOnUsersTable(TestData expectedCount){
        assertThat(userTablePage.getUserNames().size(), equalTo(expectedCount.getCount()));
    }

    @Then("'([^\"]+)' Description images are displayed on Users Table on User Table Page")
    public void checkDescriptionImagesAreDisplayedOnUsersTable(TestData expectedCount){
        assertThat(userTablePage.getDescriptionImages().size(), equalTo(expectedCount.getCount()));
    }

    @Then("'([^\"]+)' Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionTextsUnderImagesAreDisplayeOnUsersTable(TestData expectedCount){
        assertThat(userTablePage.getDescriptionTextsUnderImages().size(),
                equalTo(expectedCount.getCount()));
    }

    @Then("'([^\"]+)' checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxesAreDisplayedOnUsersTable(TestData expectedCount){
        assertThat(userTablePage.getCheckBoxes().size(), equalTo(expectedCount.getCount()));
    }

    @Then("User table contains following values:")
    public void checkUserTableContainsFollowingValues(List<UserEntity> tableArgument){
        assertThat(listUsers(),hasItems(in(tableArgument)));
    }

    @Then("Check that log shows status '([^\"]+)' for Vip checkbox")
    public void checkThatLogShowsCorrectStatusForVipCheckbox(String status){
        String logResult = "Vip: condition changed to " + status;
        checkLogRecords(logResult);
    }

    @Then("UserType dropdown contains values")
    public void userTypeDropdownContainsValues(List<String> dropdownRow){
        assertThat(userTablePage.getDropDownText(),hasItems(in(dropdownRow)));
    }

}
