public class RocketBody extends SpaceObject{
    public RocketBody(String recordId, String noradCatId, String satelliteName, String country, String orbitType, int launchYear, String launchSite, double longitude, double avgLongitude, String geohash, int daysOld) {
        super(recordId, noradCatId, satelliteName, country, orbitType, launchYear, launchSite, longitude, avgLongitude, geohash, daysOld);
    }

    @Override
    public void displayInfo() {

    }
}
