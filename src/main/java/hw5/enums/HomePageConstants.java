package hw5.enums;

import java.util.Arrays;
import java.util.List;

public enum HomePageConstants {

    COUNT_IMAGES_ON_HOME_PAGE(4),
    TEXT_ON_INDEX_PAGE_UNDER_ICONS(Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026")),

    FIRST_MAIN_HEADER("EPAM FRAMEWORK WISHES…"),

    SECOND_MAIN_HEADER("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR" +
            " INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
            "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
            "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),

    SUBHEADER("JDI GITHUB"),

    SUBHEADER_URL("https://github.com/epam/JDI");

    private String data;
    private int count;
    private List<String> items;


    HomePageConstants(String data) {
        this.data = data;
    }

    HomePageConstants(int count) {
        this.count = count;
    }

    HomePageConstants(List<String> items) {
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
