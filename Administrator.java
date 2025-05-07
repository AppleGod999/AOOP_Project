import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
        super(username, password, "Admin");
    }

    void createUser(Database db,UI s, Filereader f) throws IOException {
        String[] nu = s.displayCreateUser();
        User newuser = User.factory(nu);
        db.addUser(newuser);
        f.saveUsers(db.getUserRepo());

    }

    void manageUser(Database db, UI s,Filereader f) throws IOException {
        String uname = s.displayManageUser();
        User n = db.getUser(uname);
        if (n!=null){
            boolean done = false;
            Scanner sc = new Scanner(System.in);
            while(!done) {
                System.out.println("\tWhat would you like to update (name, password, or continue)");
                String choice = sc.nextLine().trim();
                if(choice.equals("name")){
                    System.out.print("\tEnter New Name");
                    String newname = sc.nextLine().trim();
                    n.setName(newname);
                    f.saveUsers(db.getUserRepo());
                    System.out.println();
                }else if (choice.equals("password")){
                    System.out.print("tEnter New Password");
                    String newp = sc.nextLine().trim();
                    n.setPassword(newp);
                    f.saveUsers(db.getUserRepo());
                    System.out.println();
                }else if(choice.equals("continue")){
                    done = true;
                }else{
                    System.out.println("Enter valid input");
                }
            }
        }
    }

    void deleteUser(Database db, UI s, Filereader f) throws IOException {
        String del = s.displayDeleteUser();
        User u = db.getUser(del);
        boolean done = false;
        while(!done) {
            if (u != null) {
                db.removeUser(del);
                f.saveUsers(db.getUserRepo());
                System.out.println("User Removed");
                done = true;
            } else {
                System.out.println("User not Found");
            }
        }

    }




}