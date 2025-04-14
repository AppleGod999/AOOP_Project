/**
 *represents a space debris object.
 *inherits properties from SpaceObject and adds debris-specific attributes and logic.
 * 
 * @author 
 * @version 1.0
 */
public class Debris extends SpaceObject {

    // =====================
    //debris-specific Fields
    // =====================
    private boolean isNominated;
    private boolean hasDossier;
    private boolean isUnknownObject;
    private long conjunctionCount;
    private boolean stillInOrbit;
    private String riskLevel;

    // =====================
    //constructor
    // =====================
    public Debris(String recordId, String noradCatId, String satelliteName,
                  String country, String orbitType, int launchYear, String launchSite,
                  double longitude, double avgLongitude, String geohash, int daysOld,
                  boolean isNominated, boolean hasDossier, boolean isUnknownObject, long conjunctionCount) {
        super(recordId, noradCatId, satelliteName, country, orbitType, launchYear,
              launchSite, longitude, avgLongitude, geohash, daysOld);

        this.isNominated = isNominated;
        this.hasDossier = hasDossier;
        this.isUnknownObject = isUnknownObject;
        this.conjunctionCount = conjunctionCount;
    }

    // =====================
    // Getters
    // =====================

    public boolean isStillInOrbit() {
        return stillInOrbit;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    // =====================
    // Implemented Method
    // =====================
    @Override
    public void displayInfo() {
        System.out.println("Debris ID: " + recordId + " | Name: " + satelliteName +
                           " | Country: " + country + " | Orbit: " + orbitType);
    }

    // =====================
    //debris Analysis Methods
    // =====================

    /**
     *assess if debris is still in orbit using logic based on assignment criteria.
     */
    public void assessOrbitStatus() {
        boolean hasOrbit = orbitType != null && !orbitType.isEmpty();
        boolean validLongitude = longitude != 0.0;
        boolean recentEnough = daysOld < 15000;
        boolean seenRecently = conjunctionCount >= 1;

        stillInOrbit = hasOrbit && validLongitude && recentEnough && seenRecently;
    }

    /**
     *calculates risk level based on orbital drift.
     * @return "High", "Moderate", or "Low"
     */
    public String calculateRiskLevel() {
        double drift = calculateDrift();
        if (drift > 50) {
            riskLevel = "High";
        } else if (drift > 10) {
            riskLevel = "Moderate";
        } else {
            riskLevel = "Low";
        }
        return riskLevel;
    }
}