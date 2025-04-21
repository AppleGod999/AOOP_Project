import java.util.Scanner;
public class UI {

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
    //thinking of adding some sort of security check
    // like checking for if a scientist exist via id
    int displayScientist(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Scientist:");
        System.out.println("\t1.Track Objects in Space");
        System.out.println("\t2.Assess Orbit Status");
        System.out.println("\t3.Back");

        return sc.nextInt();
    }

    int displaySpaceReg(){

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Analyze Long-term Impact");
        System.out.println("2. Generate Density Reports");
        System.out.println("3. Back");

        return sc.nextInt();
    }

    int displayPolicymaker(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Review Reports on Debris Impact");
        System.out.println("2. Asses Risk Levels for Future Space Missions");
        System.out.println("3. Back");
        return sc.nextInt();
    }

    int displayAdmin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Create User");
        System.out.println("2. Manage User");
        System.out.println("3. Delete User");
        System.out.println("4. Back");
        return sc.nextInt();
    }
}