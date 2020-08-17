package gustafbratt.client;

public class User {
    static User DEFAULT = new User("user", "user");
    String username;
    String password;

    public User(String user, String password) {
        this.username = user;
        this.password = password;
    }
}
