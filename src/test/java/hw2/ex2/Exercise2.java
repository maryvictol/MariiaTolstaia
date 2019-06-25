package hw2.ex2;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static hw2.enums.MainPageConstants.*;
import static hw2.enums.DifferentElementsPageConstant.*;
import static hw2.enums.UserCredentials.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Exercise2 extends BaseTest {

    @Test
    public void exercise2() {

        //1.	Open test site by URL

        //2.	Assert Browser title
        assertBrowserTitle("Home Page");

        //3.	Perform login
        login(PITER_CHAILOVSKII);

        //4.	Assert User name in the left-top side of screen that user is loggined
        assertThat(driver.findElement(By.id("user-name")).getText(), is(PITER_CHAILOVSKII.user));

        //5.	Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.className("dropdown")).click();
        checkContainListOfElements(By.xpath("//ul[@class='dropdown-menu']/li"),
                SERVICE_DROP_DOWN.getItems());

        //6.	Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.className("menu-title")).click();
        checkContainListOfElements(By.xpath("//ul[@class='sub']/li"),
                SERVICE_DROP_DOWN.getItems());

        //7.	Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[@href='different-elements.html']")).click();
         assertBrowserTitle("Different Elements");

        //8.	Check interface on Different elements page, it contains all needed elements
        // (4 checkboxes, 4 radios, 1 dropdown, 2 buttons)
        List<WebElement> checkBoxesList = driver.findElements(By.className("label-checkbox"));
        assertThat(checkBoxesList.size(), is(COUNT_CHECKBOXES.getCount()));

        List<WebElement> radioButtonsList = driver.findElements(By.className("label-radio"));
        assertThat(radioButtonsList.size(), is(COUNT_RADIOBUTTONS.getCount()));

        checkElementIsDisplayed(By.className("colors"));
        checkElementIsDisplayed(By.xpath("//div[@class='main-content-hg']/button"));
        checkElementIsDisplayed(By.xpath("//div[@class='main-content-hg']/input"));

        //9.	Assert that there is Right Section
        checkElementIsDisplayed(By.id("mCSB_2"));

        //10.	Assert that there is Left Section
        checkElementIsDisplayed(By.id("mCSB_2"));

        //11.	Select checkboxes
        markRequiredCheckboxes(checkBoxesList, MARKED_CHECKBOXES.getItems());

        //12.	Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox.
        // TODO Is it ossible send checkbox name as a parameter - DONE
        for (String item : MARKED_CHECKBOXES.getItems()) {
            checkLogRecord(item + ": condition changed to true");
        }

        //13.	Select radio
        markRequiredCheckboxes(radioButtonsList, MARKED_RADIOBUTTONS.getItems());

        //14.	Assert that for radiobutton there is a log row and value is corresponded to
        // the status of radiobutton.
        // TODO Is it ossible send radiobutton name as a parameter - DONE
        for (String item : MARKED_RADIOBUTTONS.getItems()) {
            checkLogRecord("metal: value changed to " + item);
        }

        //15.	Select in dropdown
        new Select(driver.findElement(By.cssSelector("div.colors > select")))
                .selectByVisibleText(SELECTED_COLOR.getData());

        //16.	Assert that for dropdown there is a log row and value is corresponded to the selected value.
        // TODO Is it ossible send dropdown name as a parameter - DONE
        checkLogRecord("Colors: value changed to " + SELECTED_COLOR.getData());

        //17.	Unselect and assert checkboxes
        markRequiredCheckboxes(checkBoxesList, MARKED_CHECKBOXES.getItems());


        //18.	Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        // TODO Is it ossible send checkbox name as a parameter - DONE
        for (String item : MARKED_CHECKBOXES.getItems()) {
            checkLogRecord(item + ": condition changed to false");
        }

        // TODO driver.close could be extracted to the AfterMethod hook - DONE


    }

}
