package hw4.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class MetalAndColorsLombok {
    private List<String> summaryRadioButtonsSelect;
    private List<String> elementsCheckBoxesSelect;
    private String colorsDropDownSelect;
    private String metalsDropDownSelect;
    private List<String> vegetablesDropDownSelect;
}
