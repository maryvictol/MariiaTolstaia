package hw5.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".benefit-icon")
    private List<WebElement> imagesOnIndexPage;

    @FindBy(id = "iframe")
    private WebElement iframe;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textUnderImagesOnIndexPage;

    @FindBy(css = ".main-title")
    private WebElement firstMainHeader;

    @FindBy(css = ".main-txt")
    private WebElement secondMainHeader;

    @FindBy(css = ".text-center > a")
    private WebElement subHeader;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    public List<WebElement> getImagesOnIndexPage() {
        return imagesOnIndexPage;
    }

    public WebElement getIframe(){
        return iframe;
    }

    public List<WebElement> getTextUnderImagesOnIndexPage() {
        return textUnderImagesOnIndexPage;
    }

    public WebElement getFirstMainHeader() {
        return firstMainHeader;
    }

    public WebElement getSecondMainHeader() {
        return secondMainHeader;
    }

    public WebElement getSubHeader() {
        return subHeader;
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }
}
