/**
 * Abstract class representing a general space object in orbit.
 * This class provides common attributes and methods shared by debris and satellite objects.
 * 
 * @author 
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
}

