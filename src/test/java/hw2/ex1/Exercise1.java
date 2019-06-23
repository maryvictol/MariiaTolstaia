package hw2.ex1;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import static hw2.ex2.enums.MainPageConstants.*;
import static hw2.ex2.enums.ConnectConstants.*;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseTest {

    @Test
    public void exercise1() {
        //1. Open test site by URL

        //2. Assert Browser title
        assertBrowserTitle("Home Page");

        //3. Perform login
        login(USER_LOGIN.getData(), PASSWORD.getData());

        //4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name")).getText(),USER.getData());

        //5. Assert Browser title
        assertBrowserTitle("Home Page");

        //6. Assert that there are 4 items on the header section are
        // displayed and they have proper texts
        checkListOfTextElements(By.cssSelector("ul.m-l8 > li"), ITEMS_ON_HEADER_SECTION.getItems());

        //7. Assert that there are 4 images on the Index Page and they are displayed
        checkDisplayedListOfImagesElements(By.cssSelector(".benefit-icon"),4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        checkListOfTextElements(By.cssSelector(".benefit-txt"), TEXT_ON_INDEX_PAGE_UNDER_ICONS.getItems());

        //9. Assert a text of the main headers
        checkTextOnPage(By.cssSelector(".main-title"), FIRST_MAIN_HEADER.getData());
        checkTextOnPage(By.cssSelector(".main-txt"), SECOND_MAIN_HEADER.getData());

        //10. Assert that there is the iframe in the center of page
        checkElementIsDisplayed(By.id("iframe"), "Iframe isn't displayed");

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(driver.findElement(By.id("iframe")));
        checkElementIsDisplayed(By.id("epam_logo"), "Epam logo isn't displayed");

        //12. Switch to original window back
        driver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        checkTextOnPage(By.cssSelector(".text-center > a"), SUBHEADER.getData());

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.cssSelector(".text-center > a")).getAttribute("href"),
                SUBHEADER_URL.getData());

        //15. Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        //16. Assert that there is Footer
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());

        //17. Close Browser
        driver.close();
    }
}
