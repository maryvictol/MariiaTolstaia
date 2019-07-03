package hw4.ex2;

import hw4.BasePage;
import hw4.BaseTest;
import hw4.MetalAndColorsPage;
import hw4.builder.MetalAndColorsLombok;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static hw4.enums.BaseEnum.MAIN_PAGE_TITLE;
import static hw4.enums.BaseEnum.METAL_AND_COLORS_TITLE;
import static hw4.enums.ConnectConstants.HOME_PAGE_URL;
import static hw4.enums.UserCredentials.USER_PITER_CHAILOVSKII;
import static org.testng.Assert.assertEquals;

public class Exercise2 extends BaseTest {

    @Test(dataProvider = "builder", dataProviderClass = ChoiceDataProvider.class)
    public void exercise2(MetalAndColorsLombok metalAndColorsLombok){

        //1	Open test site by URL
        BasePage basePage = open(HOME_PAGE_URL.getData(), BasePage.class);

        //2	Assert Browser title
        checkBrowserTitle(MAIN_PAGE_TITLE.getData());

        //3	Perform login
        basePage.login(USER_PITER_CHAILOVSKII);

        //4	Click on the link on the Header section
        basePage.getTopMetalsAndColorsOption().click();
        checkBrowserTitle(METAL_AND_COLORS_TITLE.getData());

        //6	Fill form on the page
        MetalAndColorsPage metalAndColorsPage = new MetalAndColorsPage();
        metalAndColorsPage.fillMetalAndColorsForm(metalAndColorsLombok);

        //7	Click “Submit” button
        metalAndColorsPage.getSubmitButton().click();

        //8	Check Results block output on the right-side
        //assertThat(metalAndColorsPage.getResultsLog().getText(),equals(""));
        assertEquals(metalAndColorsPage.checkLogRecords(),
                expectFormLog(metalAndColorsLombok));

    }



}
