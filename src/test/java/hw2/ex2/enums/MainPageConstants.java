package hw2.ex2.enums;

import java.util.Arrays;
import java.util.List;

public enum MainPageConstants {

     ITEMS_ON_HEADER_SECTION(Arrays.asList(
            "HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS")),

    TEXT_ON_INDEX_PAGE_UNDER_ICONS(Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…")),

    FIRST_MAIN_HEADER("EPAM FRAMEWORK WISHES…"),

    SECOND_MAIN_HEADER("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR" +
            " INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
            "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
            "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),

    SUBHEADER("JDI GITHUB"),

    SUBHEADER_URL("https://github.com/epam/JDI"),

    SERVICE_DROP_DOWN(Arrays.asList(
            "SUPPORT",
            "DATES",
            "COMPLEX TABLE",
            "SIMPLE TABLE",
            "TABLES WITH PAGES",
            "DIFFERENT ELEMENTS"));

    private String data;
    private List<String> items;


    MainPageConstants(String data) {
        this.data = data;
    }

    MainPageConstants(List<String> items) {
        this.items = items;
    }

    public String getData() {
        return data;
    }

    public List<String> getItems(){
        return items;
    }
}
