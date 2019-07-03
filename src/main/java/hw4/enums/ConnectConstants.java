// TODO It could be moved to the hw2 package
// TODO As I could see this enum uses in both tests - DONE
package hw4.enums;

public enum ConnectConstants {

    HOME_PAGE_URL("https://epam.github.io/JDI");

    private String data;

    ConnectConstants(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
