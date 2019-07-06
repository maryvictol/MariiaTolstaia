package hw5.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtons;

    @FindBy(className = "colors")
    private WebElement colorDropDown;

    @FindBy(xpath = "//div[@class='main-content-hg']/button")
    private WebElement defaultButton;

    @FindBy(xpath = "//div[@class='main-content-hg']/input")
    private WebElement button;

    @FindBy(id = "mCSB_2")
    private WebElement rightPanel;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logRowsList;

    @FindBy(css = "div.colors > select")
    private WebElement colorDropDownOptions;


    public List<WebElement> getCheckBoxes(){
        return checkBoxes;
    }

    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }

    public WebElement getColorDropDown(){
        return colorDropDown;
    }

    public WebElement getDefaultButton(){
        return defaultButton;
    }

    public WebElement getButton(){
        return button;
    }

    public WebElement getRightPanel(){
        return rightPanel;
    }

    public List<WebElement> getLogRowsList(){
        return logRowsList;
    }

    public WebElement getColorDropDownOptions(){
        return colorDropDownOptions;
    }

}
