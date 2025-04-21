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
                int scienceChoice = screen.displayScientist();
            }else if (choice == 2){

            }else if (choice == 3){

            }else if (choice == 4){

            }else if (choice == 5){
                done = true;
            }
        }



    }
}