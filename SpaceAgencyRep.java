/**
 * Space Agency Representative user role.
 */
public class SpaceAgencyRep extends User {

    public SpaceAgencyRep(String username, String password) {
        super(username, password, "SpaceAgencyRep");
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== Space Agency Representative Menu ===");
        System.out.println("1. Analyze Long-Term Impact");
        System.out.println("2. Generate Density Reports");
        System.out.println("3. Back to Main Menu");
    }
}