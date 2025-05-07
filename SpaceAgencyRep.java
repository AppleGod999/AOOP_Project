import java.util.HashMap;

/**
 * Represents a Space Agency Representative user in the space object tracking system.
 * <p>
 * Space Agency Representatives have access to tools for analyzing long-term debris impact
 * and generating debris density reports across orbital ranges.
 * </p>
 * This class extends the {@link User} class and defines its own menu behavior.
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class SpaceAgencyRep extends User {


    /**
     * Constructs a Space Agency Representative with the specified username.
     * The role is automatically set to "SpaceAgencyRep".
     *
     * @param username the representative’s username
     */
    public SpaceAgencyRep(String username, String password) {
        super(username, password, "SpaceAgencyRep");
    }


    /**
     * prints objects if they are in LEO, > 200 days, and conjunction count > 0
     * @param db database object
     * @param s ui class
     */
    public void assessLongterm(Database db,UI s){

        s.displayLongTerm();

        HashMap<Integer,SpaceObject> map = db.getSpaceRepo();
        for(SpaceObject so : map.values()){
            if(so.orbitType.equals("LEO") && so.daysOld > 200 && so.conjunctionCount > 0){
                System.out.println("Record ID: " + so.recordId + " | Name: " + so.satelliteName +
                        " | Country: " + so.country + " | Orbit Type: " + so.orbitType +
                        " | Object Type: " + so.type + " | Days Old " + so.daysOld +" | Conjuction Count " + so.conjunctionCount);
            }
        }
    }

    /**
     * prints total number of objects within a longitude range
     * @param db database object
     * @param s ui object
     */
    public void generateDensityReport(Database db, UI s){
        double[] d = s.displayDensityReport();
        HashMap<Integer, SpaceObject> map = db.getSpaceRepo();
        int count = 0;

        for(SpaceObject so : map.values()){
            double longitude = so.longitude;
            if(longitude >= d[0] && longitude <= d[1]){
                count++;
            }
        }
        System.out.println("Total Number of Objects in Range: " + count);

        for(SpaceObject so : map.values()){
            double longitude = so.longitude;
            if(longitude >= d[0] && longitude <= d[1]){
                System.out.println("Record ID " + so.recordId + " | Name: " + so.satelliteName +
                        " | Country: " + so.country + " | Orbit Type: " + so.orbitType + " | Launch Year " +
                        so.launchYear + " | Object Type: " + so.type);
            }
        }
    }
}