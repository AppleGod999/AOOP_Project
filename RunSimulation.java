import java.io.IOException;
import java.util.Map;

/**
 * Runs entire program
 * Does everything basically
 * 
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class RunSimulation {

    public static void main(String[] args) throws IOException {
        Filereader file = new Filereader();
        Database data = new Database(file.parseCsv(),file.GenUsers());
        boolean done = false;
        UI screen = new UI();
        Logger log = new Logger("logs/");



        while (!done){
            int choice = screen.displayMenu();


            if (choice == 1){
                String[] svalid= screen.displayStart("Scientist");
                Scientist s = data.getScientist(svalid[0],svalid[1]);

                if(s!=null){
                    boolean scienceDone = false;
                    while(!scienceDone){

                        int scienceChoice = screen.displayScientist();
                        if (scienceChoice == 1){
                            int track = screen.showTrackObjects();
                            if (track == 1) {

                                s.trackObjects(data.getSpaceRepo(),"ROCKET BODY");
                                log.log("Scientist tracking rocket body in orbit.");
                            }else if (track == 2){

                                s.trackObjects(data.getSpaceRepo(),"DEBRIS");
                                log.log("Scientist tracking debris in orbit.");
                            }else if (track == 3){

                                s.trackObjects(data.getSpaceRepo(),"PAYLOAD");
                                log.log("Scientist tracking payload in orbit.");
                            }else if (track == 4){

                                s.trackObjects(data.getSpaceRepo(),"UNKNOWN");
                                log.log("Scientist tracking unknown space objects in orbit.");
                            }
                        }else if (scienceChoice == 2){

                            int sob = screen.showOrbitStatus();
                            if(sob == 1){

                                s.trackLEO(data.getSpaceRepo());
                                log.log("Scientist tracking LEO objects in orbit.");
                            }else if(sob == 2){

                                s.assesDebris(data.getSpaceRepo(),file);
                                screen.printMessage("Risk level and Orbit status has been evaluated" + "\nChanges have been made in rso_metrics_write.csv" + "\nExited debris can be viewed in debris_orbit.txt");
                                log.log("Scientist assessed orbit status, object in orbit changed, risk level changed");
                            }else{
                                System.out.println("Invalid Choice");
                            }
                        }else if (scienceChoice == 3){
                            scienceDone = true;
                        }else{
                            System.out.println("Invalid Choice");
                        }
                    }
                }else{
                    screen.printMessage("Invalid ID or Password");
                }
            }else if (choice == 2){
                boolean spaceDone = false;
                while(!spaceDone){

                    int spaceRegChoice = screen.displaySpaceReg();

                    if(spaceRegChoice == 1){


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
                String[] avalid= screen.displayStart("Admin");
                Administrator a = data.getAdministrator(avalid[0],avalid[1]);
                if(a!=null){
                    while(!adminDone){
                        int adminChoice = screen.displayAdmin();

                        if (adminChoice == 1){
                            a.createUser(data,screen,file);


                        }else if (adminChoice == 2){
                            a.manageUser(data,screen,file);

                        }else if (adminChoice == 3){
                            a.deleteUser(data,screen,file);

                        }else if (adminChoice == 4){
                            adminDone = true;
                        }else{
                            System.out.println("Invalid Choice");
                        }
                    }
                }



            }else if (choice == 5 || choice == -1){
                done = true;
            }else{
                System.out.println("Invalid Choice");
            }
        }



    }
}