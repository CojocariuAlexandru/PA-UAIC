package User;

public class InvalidUserInfoException extends RuntimeException {
    public InvalidUserInfoException(String userName) {
        super("Invalid username: this username contains characters other than [a-z],[A-Z],[0-9]");
    }

    public InvalidUserInfoException(int userId) {
        super("Invalid user ID: this username's ID is not in range [0-999]");
    }
}
