package hw4;

import com.codeborne.selenide.*;
import hw4.builder.MetalAndColorsLombok;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.title;
import static hw4.enums.BaseEnum.METAL_AND_COLORS_SUMMARY_DEFAULT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Selenide.clearBrowserCookies();
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "build/reports/tests";
    }

    @AfterMethod
    public void afterMethod() {
        Selenide.close();
    }

    public void checkBrowserTitle(String expectTitle) {
        assertThat(title(), equalTo(expectTitle));
    }

    public void checkContainListOfElements(ElementsCollection elements, List<String> expectListElements) {
        List<String> listElements = elements
                .texts()
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertThat(listElements, hasItems(in(expectListElements)));
    }

    public List<String> expectFormLog(MetalAndColorsLombok metalAndColors){
        List<String> expectLog = new ArrayList<>();
        int temp = 0;
        if(metalAndColors.getSummaryRadioButtonsSelect() != null
                && !metalAndColors.getSummaryRadioButtonsSelect().isEmpty()) {
            for (String element : metalAndColors.getSummaryRadioButtonsSelect()) {
                temp += Integer.parseInt(element);
            }
        } else temp = Integer.parseInt(METAL_AND_COLORS_SUMMARY_DEFAULT.getData());
        expectLog.add("Summary: " + temp);

        if(metalAndColors.getElementsCheckBoxesSelect() != null
                && !metalAndColors.getElementsCheckBoxesSelect().isEmpty()){
                expectLog.add("Elements: " + String.join(", ", metalAndColors.getElementsCheckBoxesSelect()));
        }

        if(metalAndColors.getColorsDropDownSelect() != null
                && !metalAndColors.getColorsDropDownSelect().isEmpty()){
            expectLog.add("Color: " + metalAndColors.getColorsDropDownSelect());
        } else expectLog.add("Color: Colors");

        if(metalAndColors.getMetalsDropDownSelect() != null
                && !metalAndColors.getMetalsDropDownSelect().isEmpty()) {
            expectLog.add("Metal: " + metalAndColors.getMetalsDropDownSelect());
        } else expectLog.add("Metal: Metals");

        if(metalAndColors.getVegetablesDropDownSelect() != null
                && !metalAndColors.getVegetablesDropDownSelect().isEmpty()){
                expectLog.add("Vegetables: " + String.join(", ", metalAndColors.getVegetablesDropDownSelect()));
            } else expectLog.add("Vegetables:");
        return expectLog;
    }

}
