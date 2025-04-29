/**
 * Administrator user role.
 */
public class Administrator extends User {

    public Administrator(String username, String password) {
        super(username, password, "Administrator");
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== Administrator Menu ===");
        System.out.println("1. Create User");
        System.out.println("2. Manage User");
        System.out.println("3. Delete User");
        System.out.println("4. Back to Main Menu");
    }
}