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

    void trackObjects(HashMap<Integer, SpaceObject> map, String object){
        for (SpaceObject o : map.values()) {
            if (o.type.equals(object)){
                o.displayInfo();
            }
        }
    }

    void trackLEO(HashMap<Integer, SpaceObject> map){
        Map<Integer,SpaceObject> leoObject = SpaceObject.sortLeo(map);
        for (SpaceObject so : leoObject.values()) {
            so.displayInfo();
        }
    }

    void assesDebris(HashMap<Integer, SpaceObject> map,Filereader file) throws IOException {
        HashMap<Integer,SpaceObject> debrisMap = new HashMap<>();
        for(SpaceObject d : map.values()) {
            if(d.type.equals("DEBRIS")) {
                d.assessOrbitStatus();
                d.calculateRiskLevel();

            }
        }
        file.reWriteCSV(debrisMap);
    }
}