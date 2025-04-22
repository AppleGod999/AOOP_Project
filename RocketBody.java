public class RocketBody extends SpaceObject{

    private boolean isNominated;
    private boolean hasDossier;
    private boolean isUnknownObject;
    private long conjunctionCount;
    private boolean stillInOrbit;
    private String riskLevel;


    public RocketBody(String recordId, String noradCatId, String satelliteName,
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

    @Override
    public void displayInfo() {
        System.out.println("Rocket Body ID: " + recordId + " | Name: " + satelliteName +
                " | Country: " + country + " | Orbit: " + orbitType + " | Launch Year: " + launchYear +
                " | Longitude: " + longitude + " | Avg Longitude " + avgLongitude + " | Geohash: " + geohash +
                " | Days Old: " + daysOld);
    }
}
