/**
 * Scientist user role.
 */
public class Scientist extends User {

    public Scientist(String username, String password) {
        super(username, password, "Scientist");
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== Scientist Menu ===");
        System.out.println("1. Track Objects in Space");
        System.out.println("2. Assess Orbit Status");
        System.out.println("3. Back to Main Menu");
    }
}