import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

/**
 * Simple test runner to verify Debris and SpaceObject functionality.
 * This version avoids CSV loading and uses hardcoded values.
 * 
 * @author Miguel
 * @version 1.0
 */
public class RunSimulation {

    public static void main(String[] args) throws FileNotFoundException {
        //need to make a while loop for it but this is just an example

        Filereader file = new Filereader();
        Map<Integer,SpaceObject> data = file.parseCsv();
        boolean done = false;
        UI screen = new UI();

        while (!done){
            int choice = screen.displayMenu();
            if (choice == 1){
                boolean scienceDone = false;
                while(!scienceDone){
                    int scienceChoice = screen.displayScientist();

                    if (scienceChoice == 1){

                    }if (scienceChoice == 2){

                    }if (scienceChoice == 3){
                        scienceDone = true;
                    }else{
                        System.out.println("Invalid Choice");
                    }

                }
            }else if (choice == 2){
                boolean spaceDone = false;
                while(!spaceDone){

                    int spaceRegChoice = screen.displaySpaceReg();

                    if(spaceRegChoice == 1){
                        System.out.println("WIP Sorry :(");

                    }else if (spaceRegChoice == 2){
                        System.out.println("WIP Sorry :(");

                    }else if (spaceRegChoice== 3){
                        spaceDone = true;
                    }else{
                        System.out.println("Invalid Choice");
                    }
                }

            }else if (choice == 3){
                boolean policyDone = false;
                while(!policyDone){
                    int policyChoice = screen.displayPolicymaker();

                    if(policyChoice == 1){
                        System.out.println("WIP Sorry :(");

                    }else if (policyChoice == 2){
                        System.out.println("WIP Sorry :(");

                    }else if (policyChoice == 3){
                        policyDone = true;
                    }else{
                        System.out.println("Invalid Choice");
                    }

                }
            }else if (choice == 4){
                boolean adminDone = false;
                while(!adminDone){
                    int adminChoice = screen.displayAdmin();

                    if (adminChoice == 1){
                        System.out.println("WIP Sorry :(");
                    }else if (adminChoice == 2){
                        System.out.println("WIP Sorry :(");

                    }else if (adminChoice == 3){
                        System.out.println("WIP Sorry :(");

                    }else if (adminChoice == 4){
                        adminDone = true;
                    }else{
                        System.out.println("Invalid Choice");
                    }
                }


            }else if (choice == 5){
                done = true;
            }else{
                System.out.println("Invalid Choice");
            }
        }



    }
}