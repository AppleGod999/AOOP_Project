import java.io.FileNotFoundException;
import java.io.SyncFailedException;
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
        Logger log = new Logger("logs/");

        Map<Integer,Debris> debrisMap = new HashMap<>();
        Map<Integer,RocketBody> RocketMap = new HashMap<>();
        Map<Integer,Payload> payloadMap = new HashMap<>();
        Map<Integer,Unknown> unknownMap = new HashMap<>();

        for (Map.Entry<Integer,SpaceObject> e : data.entrySet()) {
            Integer id = e.getKey();
            SpaceObject so = e.getValue();
            if (so instanceof Debris){
                debrisMap.put(id, (Debris)so);
            }else if (so instanceof RocketBody){
                RocketMap.put(id, (RocketBody)so);
            }else if (so instanceof Payload){
                payloadMap.put(id, (Payload)so);
            }else if (so instanceof Unknown){
                unknownMap.put(id, (Unknown)so);
            }
        }

        while (!done){
            int choice = screen.displayMenu();
            if (choice == 1){
                boolean scienceDone = false;
                while(!scienceDone){
                    int scienceChoice = screen.displayScientist();

                    if (scienceChoice == 1){
                        int track = screen.showTrackObjects();
                        if (track == 1) {
                            for (RocketBody rb : RocketMap.values()) {
                                rb.displayInfo();
                            }
                        }else if (track == 2){
                            for (Debris d : debrisMap.values()) {
                                d.displayInfo();
                            }
                        }else if (track == 3){
                            for (Payload p : payloadMap.values()) {
                                p.displayInfo();
                            }
                        }else if (track == 4){
                            for (Unknown u : unknownMap.values()) {
                                u.displayInfo();
                            }
                        }
                    }else if (scienceChoice == 2){
                        int sob = screen.showOrbitStatus();

                        if(sob == 1){
                            Map<Integer, SpaceObject> leoObject = SpaceObject.sortLeo(data);
                            for (SpaceObject so : leoObject.values()) {
                                so.displayInfo();
                            }
                        }else if(sob == 2){

                        }else{
                            System.out.println("Invalid Choice");
                        }
                    }else if (scienceChoice == 3){
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