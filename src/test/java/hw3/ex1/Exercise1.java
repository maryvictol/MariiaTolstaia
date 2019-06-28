package hw3.ex1;

import hw3.BaseTest;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw3.enums.BasePageConstants.ITEMS_ON_HEADER_SECTION;
import static hw3.enums.HomePageConstants.*;
import static hw3.enums.UserCredentials.PITER_CHAILOVSKII;

public class Exercise1 extends BaseTest {

    HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void hw3_exercise1() {
        //1. Open test site by URL

        //2. Assert Browser title
        homePageSteps.assertBrowserTitle("Home Page");

        //3. Perform login
        homePageSteps.login(PITER_CHAILOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSteps.assertleftPanelUserName(PITER_CHAILOVSKII.user);

        //5. Assert Browser title
        homePageSteps.assertBrowserTitle("Home Page");

        //6. Assert that there are 4 items on the header section are
        // displayed and they have proper texts
        homePageSteps.checkMenuHeaderSectionItems(ITEMS_ON_HEADER_SECTION.getItems());

        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.checkDisplayedListOfImagesElements(COUNT_IMAGES_ON_HOME_PAGE.getCount());

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSteps.checkListOfTextElements(TEXT_ON_INDEX_PAGE_UNDER_ICONS.getItems());

        //9. Assert a text of the main headers
        homePageSteps.checkTextFirstMainHeader(FIRST_MAIN_HEADER.getData());
        homePageSteps.checkTextSecondMainHeader(SECOND_MAIN_HEADER.getData());

        //10. Assert that there is the iframe in the center of page
        homePageSteps.checkIframeIsDisplayed();

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePageSteps.switchToFrame();
        homePageSteps.checkEpamLogoIsDisplayed();

        //12. Switch to original window back
        homePageSteps.switchToOriginalWindowBack();

        //13. Assert a text of the sub header
        homePageSteps.checkTextSubHeader(SUBHEADER.getData());

        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageSteps.checkURLJdiGithubLink(SUBHEADER_URL.getData());

        //15. Assert that there is Left Section
        homePageSteps.checkLeftPanelIsDisplayed();

        //16. Assert that there is Footer
        homePageSteps.checkFooter();

        //17. Close Browser

    }
}
