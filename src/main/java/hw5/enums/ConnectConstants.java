package hw5.enums;

public enum ConnectConstants {

    URL("https://epam.github.io/JDI");

    private String data;

    ConnectConstants(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
