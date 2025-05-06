/**
 * Represents a Scientist user in the space object tracking system.
 * <p>
 * Scientists are tasked with tracking orbital objects and assessing orbit statuses,
 * including calculating debris risk levels and identifying objects still in orbit.
 * </p>
 * This class extends the {@link User} abstract class and provides a role-specific menu.
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class Scientist extends User {

    /**
     * Constructs a Scientist with the specified username.
     * The role is automatically set to "Scientist".
     *
     * @param username the scientist's username
     */
    public Scientist(String username, String password) {
        super(username, password, "Scientist");
    }

    /**
     * Displays the menu for the Scientist user, including options to track objects
     * and assess orbit status.
     */
    @Override
    public void displayMenu() {
        System.out.println("\n=== Scientist Menu ===");
        System.out.println("1. Track Objects in Space");
        System.out.println("2. Assess Orbit Status");
        System.out.println("3. Back to Main Menu");
    }
}