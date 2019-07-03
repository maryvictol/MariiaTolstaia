package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableWithPagesPage extends BasePage  {

    public TableWithPagesPage() {
        super();
    }


    @Getter
    private SelenideElement showEntriesDropdown = $(By.name("table-with-pages_length"));

    @Getter
    private ElementsCollection logRowsList = $$(By.xpath("//ul[@class='panel-body-list logs']/li"));

    @Getter
    private SelenideElement rightPanel = $(By.id("mCSB_2"));

    @Getter
    private ElementsCollection rowsInTable = $$("#table-with-pages tbody > tr");

    @Getter
    private SelenideElement searchField = $("input[type='search']");


    public void setShowEntries(String selectedValue){
        showEntriesDropdown.selectOptionByValue(selectedValue);
    }

    public void setSearchField(String searchValue){
        searchField.setValue(searchValue);
    }

}
