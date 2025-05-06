/**
 * Represents a Space Agency Representative user in the space object tracking system.
 * <p>
 * Space Agency Representatives have access to tools for analyzing long-term debris impact
 * and generating debris density reports across orbital ranges.
 * </p>
 * This class extends the {@link User} class and defines its own menu behavior.
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class SpaceAgencyRep extends User {


    /**
     * Constructs a Space Agency Representative with the specified username.
     * The role is automatically set to "SpaceAgencyRep".
     *
     * @param username the representative’s username
     */
    public SpaceAgencyRep(String username, String password) {
        super(username, password, "SpaceAgencyRep");
    }

    /**
     * Displays the menu for the Space Agency Representative, listing available actions
     * such as analyzing long-term impact and generating density reports.
     */
    @Override
    public void displayMenu() {
        System.out.println("\n=== Space Agency Representative Menu ===");
        System.out.println("1. Analyze Long-Term Impact");
        System.out.println("2. Generate Density Reports");
        System.out.println("3. Back to Main Menu");
    }
}