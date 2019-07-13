package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.UserCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionSteps extends BaseStep{

    @When("I login as user '([^\"]+)'")
    public void iLoginAsUser(UserCredentials user){
        basePage.getUserIcon().click();
        basePage.getUserLoginTextField().sendKeys(user.login);
        basePage.getPasswordTextField().sendKeys(user.password);
        basePage.getLoginButton().click();
    }

    @When("Click on '([^\"]*)' subcategory in the header")
    public void clickOnSubcategoryInHeader(String subcategory){
        basePage.getTopServiceDropDown().click();
    }

    @When("Click on Service subcategory in the left section")
    public void clickOnServiceSubcategoryInLeftSection(){
        basePage.getLeftServiceDropDown().click();
    }

    @When("Open through the header menu Service '([^\"]*)' Page")
    public void openThroughHeaderMenuServiceRequiredPage(String option){
        basePage.getTopServiceDropDown().click();
        basePage.getTopServiceDropDownOption(option).click();
    }

    @When("I click on '([^\"]+)' button in Service dropdown")
    public void iClickOnUserTableButtonInServiceDropdown(String option){
        basePage.getTopServiceDropDownOption(option).click();
    }

    @When("I mark '([^\"]+)' checkbox on Different Elements page")
    public void iMarkCheckboxOnDifferentElementsPage(String selectedCheckbox){
        for (WebElement checkBox : differentElementsPage.getCheckBoxes()) {
            if (checkBox.getText().equals(selectedCheckbox)) {
                checkBox.click();
                break;
            }
        }
    }

    @When("Select radiobutton '([^\"]+)' on Different Elements page")
    public void selectRadiobuttonOnDifferentElementsPage(String selectedRadiobutton){
        for (WebElement radiobutton : differentElementsPage.getRadioButtons()) {
            if (radiobutton.getText().equals(selectedRadiobutton)) {
                radiobutton.click();
                break;
            }
        }
    }

    @When("Select '([^\"]+)' in dropdown")
    public void selectColorInDropdown(String color){
        new Select(differentElementsPage.getColorDropDownOptions())
                .selectByVisibleText(color);
    }

    @When("I select Vip checkbox for '([^\"]+)'")
    public void iSelectVipCheckboxForUser(String user){
        userTablePage.getUserTableRow(user).findElement(By.cssSelector("td input")).click();
    }

    @When("I click on dropdown in column Type for user '([^\"]+)'")
    public void iClickOnDropdownInColumnTypeForUser(String user){
        userTablePage.getUserTableRow(user).findElement(By.cssSelector("td select")).click();
    }


}
