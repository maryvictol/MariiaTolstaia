package hw4.enums;

public enum BaseEnum {

    MAIN_PAGE_TITLE("Home Page"),

    TABLE_WITH_PAGES_TITLE("Table with pages"),

    METAL_AND_COLORS_TITLE("Metal and Colors"),

    SHOW_ENTYTIES_DEFAULT_VALUE(5),

    SHOW_ENTYTIES_SELECTED_VALUE(10),

    SEARCH_VALUE("Custom"),

    METAL_AND_COLORS_SUMMARY_DEFAULT("3");

    private String data;
    private int value;

    BaseEnum(String data) {
        this.data = data;
    }

    BaseEnum(int value){
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public int getValue(){
        return value;
    }

}
