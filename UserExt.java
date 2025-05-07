public interface UserExt {
    /**
     * Returns the username of the user.
     * @return the username
     */
    String getUsername();

    /**
     * Validates the input password against the user’s stored password.
     * @param inputPassword the password to check
     * @return true if it matches; false otherwise
     */
    boolean validatePassword(String inputPassword);

    /**
     * Returns the role of the user.
     * @return the user role
     */
    String getRole();

}
