package hw5.ex2;

import hw5.AllureAttachmentListener;
import hw5.enums.UserCredentials;
import hw5.BaseTest;
import hw5.steps.DifferentElementsPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static hw5.enums.DifferentElementsPageConstant.*;
import static hw5.enums.BasePageConstants.SERVICE_DROP_DOWN;
import static hw5.enums.UserCredentials.PITER_CHAILOVSKII;

@Listeners(AllureAttachmentListener.class)
public class Exercise2 extends BaseTest {

    DifferentElementsPageSteps differentElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        differentElementsPageSteps = new DifferentElementsPageSteps(driver);
    }

    @Feature(value = "HW 5 - Jenkins/Allure")
    @Story(value = "Check functionality of Different Elements Page")
    @Test
    public void hw5_exercise2() {
        //1.	Open test site by URL

        //2.	Assert Browser title
        differentElementsPageSteps.checkBrowserTitle("Home Page");

        //3.	Perform login
        differentElementsPageSteps.login(UserCredentials.PITER_CHAILOVSKII);

        //4.	Assert User name in the left-top side of screen that user is loggined
        differentElementsPageSteps.checkLeftPanelUserName(PITER_CHAILOVSKII.user);

        //5.	Click on "Service" subcategory in the header and check that drop down contains options
        differentElementsPageSteps.checkContainsListTopServiceDropDownOptions(SERVICE_DROP_DOWN.getItems());

        //6.	Click on Service subcategory in the left section and check that drop down contains options
        differentElementsPageSteps.checkContainsListLeftServiceDropDownOptions(SERVICE_DROP_DOWN.getItems());

        //7.	Open through the header menu Service -> Different Elements Page
        differentElementsPageSteps.openDifferentElementsPage();
        differentElementsPageSteps.checkBrowserTitle("Different Elements");

        //8.	Check interface on Different elements page, it contains all needed elements
        // (4 checkboxes, 4 radios, 1 dropdown, 2 buttons)
        differentElementsPageSteps.assertCheckBoxesSize(COUNT_CHECKBOXES.getCount());

        differentElementsPageSteps.assertRadioButtonsSize(COUNT_RADIOBUTTONS.getCount());

        differentElementsPageSteps.assertColorDropDownIsDisplayed();
        differentElementsPageSteps.assertDefaultButtonIsDisplayed();
        differentElementsPageSteps.assertButtonIsDisplayed();

        //9.	Assert that there is Right Section
        differentElementsPageSteps.assertRightPanelIsDisplayed();

        //10.	Assert that there is Left Section
        differentElementsPageSteps.checkLeftPanelIsDisplayed();

        //11.	Select checkboxes
        differentElementsPageSteps.markRequiredCheckBoxes(MARKED_CHECKBOXES.getItems());

        //12.	Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox.
        for (String item : MARKED_CHECKBOXES.getItems()) {
            differentElementsPageSteps.checkLogRecords(item + ": condition changed to true");
        }

        //13.	Select radio
        differentElementsPageSteps.markRequiredRadioButtons(MARKED_RADIOBUTTONS.getItems());

        //14.	Assert that for radiobutton there is a log row and value is corresponded to
        // the status of radiobutton.
        for (String item : MARKED_RADIOBUTTONS.getItems()) {
            differentElementsPageSteps.checkLogRecords("metal: value changed to " + item);
        }

        //15.	Select in dropdown
        differentElementsPageSteps.selectRequiredColor(SELECTED_COLOR.getData());

        //16.	Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSteps.checkLogRecords("Colors: value changed to " + SELECTED_COLOR.getData());

        //17.	Unselect and assert checkboxes
        differentElementsPageSteps.markRequiredCheckBoxes(MARKED_CHECKBOXES.getItems());

        //18.	Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        for (String item : MARKED_CHECKBOXES.getItems()) {
            differentElementsPageSteps.checkLogRecords(item + ": condition changed to false");
        }
    }

}
