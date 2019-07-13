package hw6;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    private static WebDriver driver;
    private static BasePage instance;

    @Getter
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @Getter
    @FindBy(id = "name")
    private WebElement userLoginTextField;

    @Getter
    @FindBy(id = "password")
    private WebElement passwordTextField;

    @Getter
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Getter
    @FindBy(id = "user-name")
    private WebElement topPanelUserName;

    @Getter
    @FindBy(css = "ul.m-l8 > li")
    private List<WebElement> menuHeaderSectionItems;

    @Getter
    @FindBy(id = "mCSB_1")
    private WebElement leftPanel;

    @Getter
    @FindBy(className = "dropdown")
    private WebElement topServiceDropDown;

    @Getter
    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private List<WebElement> topServiceDropDownOptions;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[@href='different-elements.html']")
    private WebElement differentElementsMenuOptions;

    @Getter
    @FindBy(className = "menu-title")
    private WebElement leftServiceDropDown;

    @Getter
    @FindBy(xpath = "//ul[@class='sub']/li")
    private List<WebElement> leftServiceDropDownOptions;

    @Getter
    @FindBy(css = ".benefit-icon")
    private List<WebElement> imagesOnIndexPage;

    @Getter
    @FindBy(css = ".benefit-txt")
    private List<WebElement> textUnderImagesOnIndexPage;

    @Getter
    @FindBy(css = ".main-title")
    private WebElement firstMainHeader;

    @Getter
    @FindBy(css = ".main-txt")
    private WebElement secondMainHeader;


    private BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static BasePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new BasePage(driver);
            BasePage.driver = driver;
        }
        return instance;
    }

    public static void clearInstance() {
        instance = null;
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public WebElement getTopServiceDropDownOption(String option){
        return driver.findElement(
                By.xpath("//ul[@class='dropdown-menu']/li/a[@href='"+option+".html']"));
    }




}
