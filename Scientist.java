import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Scientist user in the space object tracking system.
 * <p>
 * Scientists are tasked with tracking orbital objects and assessing orbit statuses,
 * including calculating debris risk levels and identifying objects still in orbit.
 * </p>
 * This class extends the {@link User} abstract class and provides a role-specific menu.
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class Scientist extends User {

    /**
     * Constructs a Scientist with the specified username.
     * The role is automatically set to "Scientist".
     *
     * @param username the scientist's username
     */
    public Scientist(String username, String password) {
        super(username, password, "Scientist");
    }

    /**
     * prints specific type of space object
     * @param map hashmap of spaceobjects
     * @param object type of object to print
     */
    void trackObjects(HashMap<Integer, SpaceObject> map, String object){
        for (SpaceObject o : map.values()) {
            if (o.type.equals(object)){
                o.displayInfo();
            }
        }
    }

    /**
     * prints all object in LEO
     * @param map hashmap of spaceobjects
     */
    void trackLEO(HashMap<Integer, SpaceObject> map){
        Map<Integer,SpaceObject> leoObject = SpaceObject.sortLeo(map);
        for (SpaceObject so : leoObject.values()) {
            so.displayInfo();
        }
    }

    /**
     * adds orbit status and risk level to csv file for debris objects
     * @param map hashmap of space objects
     * @param file filereader object
     */
    void assesDebris(HashMap<Integer, SpaceObject> map,Filereader file){
        HashMap<Integer,SpaceObject> debrisMap = new HashMap<>();
        for(SpaceObject d : map.values()) {
            if(d.type.equals("DEBRIS")) {
                debrisMap.put(Integer.parseInt(d.recordId),d);
                d.assessOrbitStatus();
                d.calculateRiskLevel();

            }
        }
        file.reWriteCSV(debrisMap);
    }
}