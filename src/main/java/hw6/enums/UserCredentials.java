package hw6.enums;

public enum UserCredentials {
    
    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String fullUserName;

    UserCredentials(String login, String password, String fullUserName) {
        this.login = login;
        this.password = password;
        this.fullUserName = fullUserName;
    }

    public String getFullUserName(){
        return fullUserName;
    }


}
