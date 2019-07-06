package hw5.voids;

import hw5.enums.UserCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userLoginTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement leftPanelUserName;

    @FindBy(css = "ul.m-l8 > li")
    private List<WebElement> menuHeaderSectionItems;

    @FindBy(id = "mCSB_1")
    private WebElement leftPanel;

    @FindBy(className = "footer-bg")
    private WebElement footer;

    @FindBy(className = "dropdown")
    private WebElement topServiceDropDown;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private List<WebElement> topServiceDropDownOptions;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[@href='different-elements.html']")
    private WebElement differentElementsMenuOptions;

    @FindBy(className = "menu-title")
    private WebElement leftServiceDropDown;

    @FindBy(xpath = "//ul[@class='sub']/li")
    private List<WebElement> leftServiceDropDownOptions;

    public void login(UserCredentials user) {
        userIcon.click();
        userLoginTextField.sendKeys(user.login);
        passwordTextField.sendKeys(user.password);
        loginButton.click();
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public String getLeftPanelUserName() {
        return leftPanelUserName.getText();
    }

    public List<WebElement> getMenuHeaderSectionItems() {
        return menuHeaderSectionItems;
    }

    public WebElement getLeftPanel() {
        return leftPanel;
    }

    public WebElement getFooter() {
        return footer;
    }

    public List<WebElement> getTopServiceDropDownOptions() {
        topServiceDropDown.click();
        return topServiceDropDownOptions;
    }

    public List<WebElement> getLeftServiceDropDownOptions() {
        leftServiceDropDown.click();
        return leftServiceDropDownOptions;
    }

    public void openDifferentElementsTab() {
        topServiceDropDown.click();
        differentElementsMenuOptions.click();
    }
}
