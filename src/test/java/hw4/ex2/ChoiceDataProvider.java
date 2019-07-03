package hw4.ex2;

import hw4.builder.MetalAndColorsLombok;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class ChoiceDataProvider {

    @DataProvider(name = "builder")
    public static Object[][] builder() {
        return new Object[][]{
                {MetalAndColorsLombok.builder()
                        .elementsCheckBoxesSelect(Arrays.asList("Earth"))
                        .colorsDropDownSelect("Yellow")
                        .metalsDropDownSelect("Gold")
                        .build()},
                {MetalAndColorsLombok.builder()
                        .summaryRadioButtonsSelect(Arrays.asList("3", "8"))
                        .vegetablesDropDownSelect(Arrays.asList("Cucumber", "Tomato"))
                        .build()},
                {MetalAndColorsLombok.builder()
                        .summaryRadioButtonsSelect(Arrays.asList("3", "2"))
                        .elementsCheckBoxesSelect(Arrays.asList("Water", "Wind", "Fire"))
                        .metalsDropDownSelect("Bronze")
                        .vegetablesDropDownSelect(Arrays.asList("Onion"))
                        .build()},
                {MetalAndColorsLombok.builder()
                        .summaryRadioButtonsSelect(Arrays.asList("6", "5"))
                        .elementsCheckBoxesSelect(Arrays.asList("Water"))
                        .colorsDropDownSelect("Green")
                        .metalsDropDownSelect("Selen")
                        .vegetablesDropDownSelect(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion"))
                        .build()},
                {MetalAndColorsLombok.builder()
                        .elementsCheckBoxesSelect(Arrays.asList("Fire"))
                        .colorsDropDownSelect("Blue")
                        .vegetablesDropDownSelect(Arrays.asList("Cucumber", "Tomato", "Vegetables"))
                        .build()}
    };
    }
}