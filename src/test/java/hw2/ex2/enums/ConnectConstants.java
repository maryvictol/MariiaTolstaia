// TODO It could be moved to the hw2 package
// TODO As I could see this enum uses in both tests
package hw2.ex2.enums;

public enum ConnectConstants {

    URL("https://epam.github.io/JDI"),

    /*  TODO
            I suggest extract user to the separate enum
            It could be used in the next format PITER("", "", "")
            To the method login you could just send only value from the enum
     */
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
