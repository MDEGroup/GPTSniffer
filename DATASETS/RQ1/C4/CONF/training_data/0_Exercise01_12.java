public class AverageSpeed {
    public static void main(String[] args) {
        double distanceInMiles = 24.0;
        double timeInHours = 1.0 + 40.0 / 60.0 + 35.0 / 3600.0;
        double distanceInKm = distanceInMiles * 1.6;
        double speedInKph = distanceInKm / timeInHours;

        System.out.println("Average speed in kilometers per hour: " + speedInKph);
    }
}