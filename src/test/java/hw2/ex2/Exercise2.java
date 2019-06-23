package hw2.ex2;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static hw2.ex2.enums.MainPageConstants.*;
import static hw2.ex2.enums.ConnectConstants.*;
import static hw2.ex2.enums.DifferentElementsPageConstant.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTest {

    @Test
    public void exercise2() {

        //1.	Open test site by URL

        //2.	Assert Browser title
        assertBrowserTitle("Home Page");

        //3.	Perform login
        login(USER_LOGIN.getData(), PASSWORD.getData());

        //4.	Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name")).getText(),USER.getData());

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
        assertEquals(checkBoxesList.size(), COUNT_CHECKBOXES.getCount());

        List<WebElement> radioButtonsList = driver.findElements(By.className("label-radio"));
        assertEquals(radioButtonsList.size(), COUNT_RADIOBUTTONS.getCount());

        checkElementIsDisplayed(By.className("colors"), "Drop-down isn't displayed");
        checkElementIsDisplayed(By.xpath("//div[@class='main-content-hg']/button"), "Default button isn't displayed");
        checkElementIsDisplayed(By.xpath("//div[@class='main-content-hg']/input"), "Default button isn't displayed");

        //9.	Assert that there is Right Section
        checkElementIsDisplayed(By.id("mCSB_2"), "Right Section isn't displayed");

        //10.	Assert that there is Left Section
        checkElementIsDisplayed(By.id("mCSB_2"), "Left Section isn't displayed");

        //11.	Select checkboxes
        markRequeredCheckboxes(checkBoxesList, MARKED_CHECKBOXES.getItems());

        //12.	Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox.
        checkLogRecord("Water: condition changed to true");
        checkLogRecord("Wind: condition changed to true");

        //13.	Select radio
        markRequeredCheckboxes(radioButtonsList, MARKED_RADIOBUTTONS.getItems());

        //14.	Assert that for radiobutton there is a log row and value is corresponded to
        // the status of radiobutton.
        checkLogRecord("metal: value changed to Selen");

        //15.	Select in dropdown
        new Select(driver.findElement(By.cssSelector("div.colors > select"))).selectByVisibleText("Yellow");

        //16.	Assert that for dropdown there is a log row and value is corresponded to the selected value.
        checkLogRecord("Colors: value changed to Yellow");

        //17.	Unselect and assert checkboxes
        markRequeredCheckboxes(checkBoxesList, MARKED_CHECKBOXES.getItems());


        //18.	Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        checkLogRecord("Water: condition changed to false");
        checkLogRecord("Wind: condition changed to false");

        driver.close();

    }

}
