/**
 * Represents an Administrator user in the space object tracking system.
 * <p>
 * Administrators are responsible for managing user accounts, including
 * creating, deleting, and modifying users.
 * </p>
 * This class extends the {@link User} abstract class and implements the role-specific menu.
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class Administrator extends User {

    /**
     * Constructs an Administrator with the specified username.
     * The role is automatically set to "Administrator".
     *
     * @param username the administrator's username
     */
    public Administrator(String username, String password) {
        super(username, password, "Administrator");
    }

    /**
     * Displays the Administrator-specific menu and handles user input.
     * This includes creating, managing, and deleting users.
     */
    @Override
    public void displayMenu() {
        System.out.println("\n=== Administrator Menu ===");
        System.out.println("1. Create User");
        System.out.println("2. Manage User");
        System.out.println("3. Delete User");
        System.out.println("4. Back to Main Menu");
    }
}