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

        System.out.print("Welcome to Tracking System! \n\tEnter User ID:");
        String userID = input.nextLine();
        System.out.print("\n\tEnter Password:");
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

        return scanner.nextInt();
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

        return sc.nextInt();
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

        return sc.nextInt();
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
        return sc.nextInt();
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

        return sc.nextInt();
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
        return sc.nextInt();
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
        return sc.nextInt();
    }

}