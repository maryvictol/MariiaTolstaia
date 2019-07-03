package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.builder.MetalAndColorsLombok;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MetalAndColorsPage extends BasePage{
    public MetalAndColorsPage() {
        super();
    }

    private ElementsCollection summaryRadioButtons = $$(By.className("radio"));

    @Getter
    private ElementsCollection elementsCheckBoxes = $$(By.className("checkbox"));

    private SelenideElement metalsDropDown = $(By.xpath("//button[@title='Metals']//span[@class='caret']"));

    private ElementsCollection metalsDropDownOptions = $$(By.xpath("//div[@id='metals']//li"));

    private  SelenideElement colorDropDown = $(By.xpath("//button[@title='Colors']"));

    private ElementsCollection colorDropDownOptions = $$(By.xpath("//div[@id='colors']//li"));

    private SelenideElement vegetablesDropDown = $(By.xpath("//button[text()='Vegetables']"));

    private ElementsCollection vegetablesDropDownOptions = $$(By.xpath("//div[@id='salad-dropdown']//li"));

    @Getter
    private SelenideElement submitButton = $(By.id("submit-button"));

    @Getter
    private ElementsCollection resultsLog = $$(By.xpath("//ul[@class='panel-body-list results']//li"));



    public void setMetalsDropDownOptions(String select){
        if(select != null && !select.isEmpty()) {
            metalsDropDown.click();
            metalsDropDownOptions.findBy(Condition.exactText(select)).click();
        }
    }

    public void setSummaryRadioButtons(List<String> elements){
        if(elements != null && !elements.isEmpty()){
            for(String element : elements){
                summaryRadioButtons.findBy(Condition.exactText(element)).click();
            }
        }
    }

    public void setElementsCheckBoxes(List<String> elements){
        if(elements != null && !elements.isEmpty()){
            for(String element : elements){
                elementsCheckBoxes.findBy(Condition.exactText(element)).click();
            }
        }
    }

    public void setColorsDropDownSelect(String color){
        if(color != null && !color.isEmpty()){
            colorDropDown.click();
            colorDropDownOptions.findBy(Condition.exactText(color)).click();
        }
    }

    public void setVegetablesDropDownOptions(List<String> vegetables){
        vegetablesDropDown.click();
        vegetablesDropDownOptions.findBy(Condition.exactText("Vegetables")).click();
        if(vegetables != null && !vegetables.isEmpty()){
            for(String element : vegetables){
                vegetablesDropDownOptions.findBy(Condition.exactText(element)).click();
            }
        }
    }

    public void fillMetalAndColorsForm(MetalAndColorsLombok metalAndColorsLombok){
        setSummaryRadioButtons(metalAndColorsLombok.getSummaryRadioButtonsSelect());
        setElementsCheckBoxes(metalAndColorsLombok.getElementsCheckBoxesSelect());
        setColorsDropDownSelect(metalAndColorsLombok.getColorsDropDownSelect());
        setMetalsDropDownOptions(metalAndColorsLombok.getMetalsDropDownSelect());
        setVegetablesDropDownOptions(metalAndColorsLombok.getVegetablesDropDownSelect());
    }

    public List<String> checkLogRecords() {
        List<String> listElements = getResultsLog()
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        return listElements;
    }
}
