package hw6.steps;

import hw6.BasePage;
import hw6.DifferentElementsPage;
import hw6.UserTablePage;
import hw6.commonPackage.TestContext;
import hw6.commonPackage.UserEntity;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseStep {

    protected BasePage basePage;
    protected UserTablePage userTablePage;
    protected DifferentElementsPage differentElementsPage;

    public BaseStep(){
        basePage = BasePage.getInstance(TestContext.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(TestContext.getDriver());
        userTablePage = UserTablePage.getInstance(TestContext.getDriver());
    }

    public List<UserEntity> listUsers(){
        List<UserEntity> entityList = new ArrayList<>();
        for(int i=0; i < userTablePage.getUserNames().size(); i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setNumber(userTablePage.getNumberTypes().get(i).getText());
            userEntity.setUser(userTablePage.getUserNames().get(i).getText());
            userEntity.setDescription(userTablePage.getDescriptionTextsUnderImages()
                    .get(i).getText().replaceAll("\n", " "));
            entityList.add(userEntity);
        }
        return entityList;
    }

    public void checkDisplayedListOfImagesElements(int expectElementsNumber){
        List<WebElement> elements = basePage.getImagesOnIndexPage();
        assertThat(elements.size(), equalTo(expectElementsNumber));
        SoftAssert softAssert = new SoftAssert();
        for (WebElement icon : elements) {
            softAssert.assertTrue(icon.isDisplayed());
        }
        softAssert.assertAll();
    }

    public void checkListOfTextElements(List<String> expectListElements) {
        List<String> listElements = basePage.getTextUnderImagesOnIndexPage()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, equalTo(expectListElements));
    }

    public void checkTextFirstMainHeader(String expectText) {
        checkTextOnPage(basePage.getFirstMainHeader(), expectText);
    }

    public void checkTextSecondMainHeader(String expectText) {
        checkTextOnPage(basePage.getSecondMainHeader(), expectText);
    }

    public void checkTextOnPage(WebElement actualText, String expectText) {
        assertThat(actualText.isDisplayed(), is(true));
        assertThat(actualText.getText(), equalTo(expectText));
    }

    public void checkContainListOfElements(List<WebElement> elements, List<String> expectListElements) {
        List<String> listElements = elements
                .stream()
                .map(WebElement::getText)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertThat(listElements,hasItems(in(expectListElements)));
    }

    public void checkLogRecords(String expect) {
        List<String> listElements = differentElementsPage.getLogRowsList()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(listElements, hasItem(endsWith(expect)));
    }

}
