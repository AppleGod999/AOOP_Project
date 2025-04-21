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

    void displaySpaceReg(){

    }
    void displayAdmin(){

    }
}