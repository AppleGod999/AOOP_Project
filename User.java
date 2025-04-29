/**
 * Abstract parent class representing a user of the system.
 */
public abstract class User {
    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public String getRole() {
        return role;
    }

    /**
     * Displays the menu options for the user based on their role.
     */
    public abstract void displayMenu();
}