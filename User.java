/**
 * Abstract base class representing a generic user in the space object tracking system.
 * <p>
 * This class defines shared fields and functionality for all user roles, including
 * Scientist, Administrator, and Space Agency Representative.
 * </p>
 * 
 * Each subclass must implement the {@code displayMenu()} method to define role-specific actions.
 * 
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public abstract class User implements UserExt{
    /** The username of the user. */
    protected String username;
    /** The password for the user. */
    protected String password;
    /** The role of the user. */
    protected String role;

    /**
     * Constructs a User with a specified username and role.
     *
     * @param username the name used to identify the user
     * @param role the role assigned to the user
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Returns the username of the user.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /** 
     * Validates inputted user password  
     * 
     * @return the password is valid or not
     */
    public boolean validatePassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    /**
     * Returns the role of the user.
     * 
     * @return the user role
     */
    public String getRole() {
        return role;
    }



    public User factory(String[] data){

        if (data[2].equals("Scientist")){
            return new Scientist(data[0],data[1]);
        }else if (data[2].equals("Admin")) {
            return new Administrator(data[0], data[1]);
        }else if (data[2].equals("SpaceAgencyRep")) {
            return  new SpaceAgencyRep(data[0], data[1]);
        }
        return null;
    }
}