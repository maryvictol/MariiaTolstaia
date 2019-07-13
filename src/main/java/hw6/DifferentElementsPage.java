package hw6;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage{

    private static WebDriver driver;
    private static DifferentElementsPage instance;

    @Getter
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxes;

    @Getter
    @FindBy(className = "label-radio")
    private List<WebElement> radioButtons;

    @Getter
    @FindBy(className = "colors")
    private WebElement colorDropDown;

    @Getter
    @FindBy(xpath = "//div[@class='main-content-hg']/button")
    private WebElement defaultButton;

    @Getter
    @FindBy(xpath = "//div[@class='main-content-hg']/input")
    private WebElement button;

    @Getter
    @FindBy(id = "mCSB_2")
    private WebElement rightPanel;

    @Getter
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logRowsList;

    @Getter
    @FindBy(css = "div.colors > select")
    private WebElement colorDropDownOptions;

    private DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static DifferentElementsPage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new DifferentElementsPage(driver);
            DifferentElementsPage.driver = driver;
        }
        return instance;
    }

    public static void clearInstance() {
        instance = null;
    }
}
