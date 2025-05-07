import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class representing a general space object in orbit.
 * This class provides common attributes and methods shared by debris and satellite objects.
 * 
 * @author Miguel
 * @version 1.0
 */
public class SpaceObject {

    // =====================
    //fields
    // =====================
    protected String recordId;
    protected String noradCatId;
    protected String satelliteName;
    protected String country;
    protected String orbitType;
    protected String type;
    protected int launchYear;
    protected String launchSite;
    protected double longitude;
    protected double avgLongitude;
    protected String geohash;
    protected int daysOld;
    protected boolean stillInOrbit;
    protected String riskLevel;
    protected boolean isNominated;
    protected boolean hasDossier;
    protected boolean isUnknownObject;
    protected long conjunctionCount;

    // =====================
    // Constructor
    // =====================
    public SpaceObject(){}
    public SpaceObject(String recordId, String noradCatId, String satelliteName,
                       String country, String orbitType, String type, int launchYear, String launchSite,
                       double longitude, double avgLongitude, String geohash, int daysOld,
                       boolean isNominated, boolean hasDossier, boolean isUnknownObject, long conjunctionCount) {
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
        this.type = type;
        this.isNominated = isNominated;
        this.hasDossier = hasDossier;
        this.isUnknownObject = isUnknownObject;
        this.conjunctionCount = conjunctionCount;
    }

    // =====================
    //abstract Methods
    // =====================
    /**
     *displays general information about the space object.
     */
    public void displayInfo(){

        String type = this.type;
        System.out.println(type + " ID: " + recordId + " | Name: " + satelliteName +
                " | Country: " + country + " | Orbit: " + orbitType + " | Launch Year: " + launchYear +
                " | Longitude: " + longitude + " | Avg Longitude " + avgLongitude + " | Geohash: " + geohash +
                " | Days Old: " + daysOld);
    };

    public String display(){
        return type + " ID: " + recordId + " | Name: " + satelliteName +
                " | Country: " + country + " | Orbit: " + orbitType + " | Launch Year: " + launchYear +
                " | Longitude: " + longitude + " | Avg Longitude " + avgLongitude + " | Geohash: " + geohash +
                " | Days Old: " + daysOld;
    }

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

    /**
     *assess if debris is still in orbit using logic based on assignment criteria.
     */
    public void assessOrbitStatus() {
        boolean hasOrbit = (orbitType != null && !orbitType.isEmpty()) && !orbitType.equals("Unknown Orbit Category");
        boolean validLongitude = longitude != 0.0;
        boolean recentEnough = daysOld < 15000;
        boolean seenRecently = conjunctionCount >= 1;

        stillInOrbit = hasOrbit && validLongitude && recentEnough && seenRecently;
    }

    /**
     * @return still in orbit
     */
    public boolean isStillInOrbit() {
        return stillInOrbit;
    }

    /**
     * @return risk level
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * calculates risk level based on orbital drift.
     */
    public void calculateRiskLevel() {
        double drift = calculateDrift();
        if (drift > 50) {
            riskLevel = "HIGH";
        } else if (drift > 10) {
            riskLevel = "MODERATE";
        } else {
            riskLevel = "LOW";
        }

    }
}

