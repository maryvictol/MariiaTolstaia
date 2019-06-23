package hw2.ex2.enums;
import java.util.Arrays;
import java.util.List;

public enum DifferentElementsPageConstant {
    COUNT_CHECKBOXES(4),

    COUNT_RADIOBUTTONS(4),

    MARKED_CHECKBOXES(Arrays.asList("Water",  "Wind")),

    MARKED_RADIOBUTTONS(Arrays.asList("Selen"));


    private String data;
    private int count;
    private List<String> items;


    DifferentElementsPageConstant(String data) {
        this.data = data;
    }

    DifferentElementsPageConstant(int count) {
        this.count = count;
    }

    DifferentElementsPageConstant(List<String> items) {
        this.items = items;
    }

    public String getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public List<String> getItems(){
        return items;
    }
}
