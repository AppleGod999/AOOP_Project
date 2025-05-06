/**
 * Custom exception thrown when a user attempts to access a menu or functionality
 * that they are not authorized to access based on their role.
 * <p>
 * This is commonly used to restrict access to menu options by role (e.g., Scientist,
 * Space Agency Representative, Administrator).
 * </p>
 * 
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class UnauthorizedAccessException extends Exception {

    /**
     * Constructs a default UnauthorizedAccessException.
     */
    public UnauthorizedAccessException() {
        super("You do not have permission to perform this action.");
    }

    /**
     * Constructs an UnauthorizedAccessException with a custom message.
     * 
     * @param message Detailed explanation of the unauthorized action
     */
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}