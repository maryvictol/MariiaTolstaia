package hw6;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage{

    private static WebDriver driver;
    private static UserTablePage instance;

    @FindBy(css = "table tr")
    private List<WebElement> userTableRow;

    @Getter
    @FindBy(xpath = "//tbody/tr//td[1]")
    private List<WebElement> numberTypes;

    @Getter
    @FindBy(xpath = "//td/select")
    private List<WebElement> typeDropdowns;

    @Getter
    @FindBy(xpath = "//tbody/tr//td[3]/a")
    private List<WebElement> userNames;

    @Getter
    @FindBy(xpath = "//td/img")
    private List<WebElement> descriptionImages;

    @Getter
    @FindBy(css = ".user-descr span")
    private List<WebElement> descriptionTextsUnderImages;

    @Getter
    @FindBy(xpath = "//div/input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    public WebElement getUserTableRow(String string) {
        return userTableRow.stream()
                .filter(element -> element.getText().contains(string))
                .findAny().get();
    }

    public List<String> getDropDownText() {
        return typeDropdowns.get(0)
                .findElements(By.cssSelector("option")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTablePage(driver);
            UserTablePage.driver = driver;
        }
        return instance;
    }

    public static void clearInstance() {
        instance = null;
    }

}
