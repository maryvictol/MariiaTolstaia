package hw2.enums;

public enum UserCredentials {
    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String user;

    UserCredentials (String login, String password, String user) {
        this.login = login;
        this.password = password;
        this.user = user;
    }



}
