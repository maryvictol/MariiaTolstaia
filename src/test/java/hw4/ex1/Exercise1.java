package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import hw4.BasePage;
import hw4.BaseTest;
import hw4.TableWithPagesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static hw4.enums.BaseEnum.*;
import static hw4.enums.ConnectConstants.*;
import static hw4.enums.MainPageConstants.*;
import static hw4.enums.UserCredentials.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;


public class Exercise1 extends BaseTest {

    // TODO Field does not used)

    @Test
    public void exercise1() {
        //1	Open test site by URL
        BasePage basePage = open(HOME_PAGE_URL.getData(), BasePage.class);

        //2	Assert Browser title
        checkBrowserTitle(MAIN_PAGE_TITLE.getData());

        //3	Perform login
        basePage.login(USER_PITER_CHAILOVSKII);

        //4	Assert User name in the left-top side of screen that user is loggined
        basePage.getLeftPanelUserName().shouldHave(text(USER_PITER_CHAILOVSKII.user));

        //5	Click on "Service" subcategory in the header and check that drop down contains options
        checkContainListOfElements(basePage.getTopServiceDropDownOptions(),
                            SERVICE_DROP_DOWN.getItems());

        //6	Click on Service subcategory in the left section and check that drop down contains options
        checkContainListOfElements(basePage.getLeftServiceDropDownOptions(),
                            SERVICE_DROP_DOWN.getItems());

        //7	Open through the header menu Service -> Table with pages
        basePage.openDifferentElementsTab();
        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage();
        checkBrowserTitle(TABLE_WITH_PAGES_TITLE.getData());

        //8	Check that default value for Show entries drop-down is 5
        tableWithPagesPage.getShowEntriesDropdown()
                .shouldHave(Condition.text(Integer.toString(SHOW_ENTYTIES_DEFAULT_VALUE.getValue())));

        //9	Assert that there is Right Section
        tableWithPagesPage.getRightPanel().shouldBe(visible);

        //10	Assert that there is Left Section
        tableWithPagesPage.getLeftPanel().shouldBe(visible);

        //11	Select new value for the entries in the drop-down list
        tableWithPagesPage.setShowEntries(Integer.toString(SHOW_ENTYTIES_SELECTED_VALUE.getValue()));
        tableWithPagesPage.getShowEntriesDropdown()
                .shouldHave(Condition.text(Integer.toString(SHOW_ENTYTIES_SELECTED_VALUE.getValue())));

        //12	Assert that for the dropdown there is an individual log row and value is corresponded
        // to the value of dropdown.
        assertThat(tableWithPagesPage.getLogRowsList().texts(),
                hasItem(endsWith("length, new value=" + SHOW_ENTYTIES_SELECTED_VALUE.getValue())));

        //13	Assert that in the table displayed corrected amount of entries
        tableWithPagesPage.getRowsInTable()
                .shouldHave(CollectionCondition.size(SHOW_ENTYTIES_SELECTED_VALUE.getValue()));

        //14	Type in Search text field
        tableWithPagesPage.setSearchField(SEARCH_VALUE.getData());

        //15	Assert the table contains only records with Search field value
        tableWithPagesPage.getRowsInTable().stream()
                .forEach(selenideElement -> selenideElement.shouldHave(text("Custom")));

    }
}
