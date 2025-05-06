/**
 * Custom exception thrown when a user selects an invalid or unsupported menu option.
 * <p>
 * This exception is used to handle incorrect input choices in user interface flows
 * for roles such as Scientist, Administrator, and Space Agency Representative.
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class InvalidMenuOptionException extends Exception {

    /**
     * Constructs a default InvalidMenuOptionException.
     */
    public InvalidMenuOptionException() {
        super("Invalid menu option selected.");
    }

    /**
     * Constructs an InvalidMenuOptionException with a custom message.
     * 
     * @param message Description of the invalid selection
     */
    public InvalidMenuOptionException(String message) {
        super(message);
    }
}