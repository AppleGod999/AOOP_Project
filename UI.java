import java.util.Scanner;

/**
 * I/O class, handles menus
 * @author Diego
 * @version 1.0
 */
public class UI {

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
        System.out.println("1. Analyze Long-term Impact");
        System.out.println("2. Generate Density Reports");
        System.out.println("3. Back");

        return sc.nextInt();
    }

    /**
     * prints policymaker menu
     * @return returns choice
     */
    int displayPolicymaker(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Review Reports on Debris Impact");
        System.out.println("2. Asses Risk Levels for Future Space Missions");
        System.out.println("3. Back");
        return sc.nextInt();
    }

    /**
     * prints admin meny
     * @return returns choice
     */
    int displayAdmin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Create User");
        System.out.println("2. Manage User");
        System.out.println("3. Delete User");
        System.out.println("4. Back");
        return sc.nextInt();
    }

}