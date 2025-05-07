import java.util.Scanner;

/**
 * I/O class, handles menus
 * @author Diego
 * @version 1.0
 */
public class UI {


    /**
     * Display's start meny
     * @return array containing string and password
     */
    String[] displayStart(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Login:");
        System.out.print("\tEnter User ID: ");
        String userID = input.nextLine();
        System.out.print("\tEnter Password: ");
        String password = input.nextLine();

        return new String[]{userID, password};
    }

    /**
     * prints message m
     * @param m string containing a message
     */
    void printMessage(String m){
        System.out.println(m);
    }
    /**
     * prints main menu
     * @return
     */
    int displayMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Low Earth Orbit (LEO) Tracking System:");
        System.out.println("\t1.Scientist");
        System.out.println("\t2.Space Agency Representative");
        System.out.println("\t3.Policymaker");
        System.out.println("\t4.Adminstrator");
        System.out.println("\t5.Exit");
        try{
            String in = scanner.nextLine();
            if(in.equals("EXIT")) {
                return 5;
            }
            return Integer.parseInt(in.trim());
        }catch (NumberFormatException e){
            return -1;
        }catch (Exception e){
            return -2;
        }

    }

    /**
     * prints the scientist menu
     * @return returns choice
     */
    int displayScientist(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Scientist:");
        System.out.println("\t1.Track Objects in Space");
        System.out.println("\t2.Assess Orbit Status");
        System.out.println("\t3.Back");
        try{
            String in = sc.nextLine();
            return Integer.parseInt(in.trim());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    /**
     * prints the tracking objects menu
     * @return returns choice
     */
    int showTrackObjects(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Track Objects:");
        System.out.println("\t1.Rocket Body");
        System.out.println("\t2.Debris");
        System.out.println("\t3.Payload");
        System.out.println("\t4.Unknown");

        try{
            String in = sc.nextLine();
            return Integer.parseInt(in.trim());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    /**
     * prints orbit status
     * @return returns choice
     */
    int showOrbitStatus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Orbit Status:");
        System.out.println("\t1.Track Objects in LEO");
        System.out.println("\t2.Assess if debris still in orbit");
        try{
            String in = sc.nextLine();
            return Integer.parseInt(in.trim());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    /**
     * prints space reg menu
     * @return returns choice
     */
    int displaySpaceReg(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Space Representative:");
        System.out.println("\t1. Analyze Long-term Impact");
        System.out.println("\t2. Generate Density Reports");
        System.out.println("\t3. Back");

        try{
            String in = sc.nextLine();
            return Integer.parseInt(in.trim());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    /**
     * prints policymaker menu
     * @return returns choice
     */
    int displayPolicymaker(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Policymaker:");
        System.out.println("\t1. Review Reports on Debris Impact");
        System.out.println("\t2. Asses Risk Levels for Future Space Missions");
        System.out.println("\t3. Back");
        try{
            String in = sc.nextLine();
            return Integer.parseInt(in.trim());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    /**
     * prints admin meny
     * @return returns choice
     */
    int displayAdmin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Admin:");
        System.out.println("\t1. Create User");
        System.out.println("\t2. Manage User");
        System.out.println("\t3. Delete User");
        System.out.println("\t4. Back");
        try{
            String in = sc.nextLine();
            return Integer.parseInt(in.trim());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    /**
     * display createuser menu
     * @return array of new user info
     */
    String[] displayCreateUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Create New User");
        System.out.print("\tEnter New Username: ");
        String name = scan.nextLine();
        System.out.print("\tEnter New User Password: ");
        String password = scan.nextLine();
        System.out.print("\tEnter New Use Role: ");
        String role = scan.nextLine();

        return new String[]{name,password,role};
    }

    /**
     * display manage user menu
     * @return user to manage
     */
    String displayManageUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Manage User");
        System.out.println("\tEnter Username to manage User: ");
        return scan.nextLine();
    }

    /**
     * display delete user menu
     * @return user to delete
     */
    String displayDeleteUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Delete User");
        System.out.print("\tEnter Username to delete User: ");
        System.out.println();
        return sc.nextLine();
    }

    /**
     * prints generating long term report menu
     */
    void displayLongTerm(){
        System.out.println("Generating Long Term Report");
    }

    /**
     * display density report menu
     * @return array of longitude range
     */
    double[] displayDensityReport(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Generate Density Report");
            System.out.print("\tEnter Minimum Longitude (ex. 12.1234567) :");
            double min = sc.nextDouble();
            System.out.print("\tEnter Maximum Longitude (ex. 12.1234567) :");
            double max = sc.nextDouble();
            return new double[]{min,max};
        }catch (NumberFormatException e){
            System.out.println("Invalid input");
        }
        return null;
    }

}