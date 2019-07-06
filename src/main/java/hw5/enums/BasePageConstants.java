package hw5.enums;

import java.util.Arrays;
import java.util.List;

public enum BasePageConstants {

     ITEMS_ON_HEADER_SECTION(Arrays.asList(
            "HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS")),

    SERVICE_DROP_DOWN(Arrays.asList(
            "SUPPORT",
            "DATES",
            "COMPLEX TABLE",
            "SIMPLE TABLE",
            "TABLES WITH PAGES",
            "DIFFERENT ELEMENTS"));

    private String data;
    private List<String> items;

    BasePageConstants(String data) {
        this.data = data;
    }

    BasePageConstants(List<String> items) {
        this.items = items;
    }

    public String getData() {
        return data;
    }

    public List<String> getItems(){
        return items;
    }
}