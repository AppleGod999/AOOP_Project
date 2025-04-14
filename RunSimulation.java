/**
 * Simple test runner to verify Debris and SpaceObject functionality.
 * This version avoids CSV loading and uses hardcoded values.
 * 
 * @author Miguel
 * @version 1.0
 */
public class RunSimulation {

    public static void main(String[] args) {
        System.out.println("=== Testing Debris and SpaceObject Classes ===");

        // Create a test Debris object with simulated values
        Debris testDebris = new Debris(
            "12345",                 // recordId
            "56789",                 // noradCatId
            "TEST-SAT-1",            // satelliteName
            "US",                    // country
            "LEO",                   // orbitType
            2005,                    // launchYear
            "AFETR",                 // launchSite
            25.0,                    // longitude
            20.0,                    // avgLongitude
            "9q9hv",                 // geohash
            14000,                  // daysOld
            false,                  // isNominated
            true,                   // hasDossier
            false,                  // isUnknownObject
            5                       // conjunctionCount
        );

        // Display the debris info
        testDebris.displayInfo();

        // Calculate orbital drift
        double drift = testDebris.calculateDrift();
        System.out.println("Calculated Drift: " + drift);

        // Assess orbit status
        testDebris.assessOrbitStatus();
        System.out.println("Still in Orbit? " + (testDebris.isStillInOrbit() ? "Yes" : "No"));

        // Calculate risk level
        String risk = testDebris.calculateRiskLevel();
        System.out.println("Risk Level: " + risk);
    }
}