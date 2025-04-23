import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class representing a general space object in orbit.
 * This class provides common attributes and methods shared by debris and satellite objects.
 * 
 * @author Miguel
 * @version 1.0
 */
public abstract class SpaceObject {

    // =====================
    //fields
    // =====================
    protected String recordId;
    protected String noradCatId;
    protected String satelliteName;
    protected String country;
    protected String orbitType;
    protected int launchYear;
    protected String launchSite;
    protected double longitude;
    protected double avgLongitude;
    protected String geohash;
    protected int daysOld;
    protected boolean stillInOrbit;
    protected String riskLevel;

    // =====================
    // Constructor
    // =====================
    public SpaceObject(String recordId, String noradCatId, String satelliteName,
                       String country, String orbitType, int launchYear, String launchSite,
                       double longitude, double avgLongitude, String geohash, int daysOld) {
        this.recordId = recordId;
        this.noradCatId = noradCatId;
        this.satelliteName = satelliteName;
        this.country = country;
        this.orbitType = orbitType;
        this.launchYear = launchYear;
        this.launchSite = launchSite;
        this.longitude = longitude;
        this.avgLongitude = avgLongitude;
        this.geohash = geohash;
        this.daysOld = daysOld;
    }

    // =====================
    //abstract Methods
    // =====================
    /**
     *displays general information about the space object.
     */
    public abstract void displayInfo();

    // =====================
    //utility Methods
    // =====================
    /**
     *calculates orbital drift based on current vs average longitude.
     * @return absolute value of (longitude - avgLongitude)
     */
    public double calculateDrift() {
        return Math.abs(this.longitude - this.avgLongitude);
    }

    //(optionally, add getters/setters later if needed depending on the need of the project as we go)

    /**
     * Space Object factory, creates the child classes depending on input
     * @param type the type of object to create
     * @param data array of data to create object
     * @return returns the desired object
     */
    public static SpaceObject create (String type,String[] data){

        if(type.equals("DEBRIS")){
            return new Debris(
                    data[0], //record_id
                    data[1], //norad_id
                    data[2], //satellite name
                    data[3], //country
                    data[4], // approx orbit
                    Integer.parseInt(data[6].trim()), // launch year
                    data[7], // launch_site
                    Double.parseDouble(data[8].trim()), //longitude
                    Double.parseDouble(data[9].trim()), //avg longitude
                    data[10], //geohash
                    Integer.parseInt(data[18].trim()), //days old
                    Boolean.parseBoolean(data[12].trim()), //is nominated
                    Boolean.parseBoolean(data[14].trim()), //has dossier
                    Boolean.parseBoolean(data[20].trim()), //isUnknown
                    Long.parseLong(data[19].trim()));//conjunction
        }else if (type.equals("ROCKET BODY")){
            return new RocketBody(
                    data[0], //record_id
                    data[1], //norad_id
                    data[2], //satellite name
                    data[3], //country
                    data[4], // approx orbit
                    Integer.parseInt(data[6].trim()), // launch year
                    data[7], // launch_site
                    Double.parseDouble(data[8].trim()), //longitude
                    Double.parseDouble(data[9].trim()), //avg longitude
                    data[10], //geohash
                    Integer.parseInt(data[18].trim()), //days old
                    Boolean.parseBoolean(data[12].trim()), //is nominated
                    Boolean.parseBoolean(data[14].trim()), //has dossier
                    Boolean.parseBoolean(data[20].trim()), //isUnknown
                    Long.parseLong(data[19].trim()));//conjunction
        }else if (type.equals("PAYLOAD")){
            return new Payload(
                    data[0], //record_id
                    data[1], //norad_id
                    data[2], //satellite name
                    data[3], //country
                    data[4], // approx orbit
                    Integer.parseInt(data[6].trim()), // launch year
                    data[7], // launch_site
                    Double.parseDouble(data[8].trim()), //longitude
                    Double.parseDouble(data[9].trim()), //avg longitude
                    data[10], //geohash
                    Integer.parseInt(data[18].trim()), //days old
                    Boolean.parseBoolean(data[12].trim()), //is nominated
                    Boolean.parseBoolean(data[14].trim()), //has dossier
                    Boolean.parseBoolean(data[20].trim()), //isUnknown
                    Long.parseLong(data[19]));//conjunction
        }else if(type.equals("UNKNOWN")){
            return new Unknown(
                    data[0], //record_id
                    data[1], //norad_id
                    data[2], //satellite name
                    data[3], //country
                    data[4], // approx orbit
                    Integer.parseInt(data[6].trim()), // launch year
                    data[7], // launch_site
                    Double.parseDouble(data[8].trim()), //longitude
                    Double.parseDouble(data[9].trim()), //avg longitude
                    data[10], //geohash
                    Integer.parseInt(data[18].trim()), //days old
                    Boolean.parseBoolean(data[12].trim()), //is nominated
                    Boolean.parseBoolean(data[14].trim()), //has dossier
                    Boolean.parseBoolean(data[20].trim()), //isUnknown
                    Long.parseLong(data[19].trim()));//conjunction
        }
        return null;
    }

    /**
     * filters global map by LEO
     * @param map global map of all space objects
     * @return returns map of only objects with LEO
     */
    public static Map<Integer, SpaceObject> sortLeo(Map<Integer, SpaceObject> map) {
        Map<Integer, SpaceObject> leoMap = new HashMap<Integer, SpaceObject>();

        for(Map.Entry<Integer, SpaceObject> so : map.entrySet()) {
            int id = so.getKey();
            SpaceObject val = so.getValue();
            if (val.orbitType.equals("LEO")){
                leoMap.put(id,val);
            }
        }
        return leoMap;
    }
}

