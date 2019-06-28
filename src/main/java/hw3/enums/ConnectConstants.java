// TODO It could be moved to the hw2 package
// TODO As I could see this enum uses in both tests - DONE
package hw3.enums;

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
