package hw2.ex2.enums;

public enum ConnectConstants {

    URL("https://epam.github.io/JDI"),

    USER_LOGIN("epam"),
    PASSWORD("1234"),
    USER("PITER CHAILOVSKII");

    private String data;

    ConnectConstants(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
