package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.UserCredentials;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    public BasePage() {
        page(this);
    }

    private SelenideElement userIcon = $(By.id("user-icon"));

    private SelenideElement userLoginTextField = $(By.id("name"));

    private SelenideElement passwordTextField = $(By.id("password"));

    private SelenideElement loginButton = $(By.id("login-button"));

    @Getter
    private SelenideElement leftPanelUserName = $(By.id("user-name"));

    private ElementsCollection menuHeaderSectionItems = $$("ul.m-l8 > li");

    @Getter
    private SelenideElement leftPanel = $(By.id("mCSB_1"));

    private SelenideElement leftServiceDropDown = $(By.className("menu-title"));

    private ElementsCollection leftServiceDropDownOptions = $$(By.xpath("//ul[@class='sub']/li"));

    private SelenideElement topServiceDropDown = $(By.className("dropdown"));

    private ElementsCollection topServiceDropDownOptions = $$(By.xpath("//ul[@class='dropdown-menu']/li"));

    private SelenideElement tableWithPagesMenuOptions = $(By.xpath("//li/a[@href='table-pages.html']"));

    @Getter
    private SelenideElement topMetalsAndColorsOption = $(By.xpath("//li/a[@href='metals-colors.html']"));


    public void login(UserCredentials user) {
        userIcon.click();
        userLoginTextField.sendKeys(user.login);
        passwordTextField.sendKeys(user.password);
        loginButton.click();
    }

    public ElementsCollection getTopServiceDropDownOptions() {
        topServiceDropDown.click();
        return topServiceDropDownOptions;
    }

    public ElementsCollection getLeftServiceDropDownOptions() {
        leftServiceDropDown.click();
        return leftServiceDropDownOptions;
    }

    public void openDifferentElementsTab() {
        topServiceDropDown.click();
        tableWithPagesMenuOptions.click();
    }
}
