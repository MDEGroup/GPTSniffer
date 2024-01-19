public class AverageSpeed {

    public static void main(String[] args) {
        // Runner's details
        double kilometers = 14.0;
        int minutes = 45;
        int seconds = 30;

        // Conversion factor from kilometers to miles
        double milesPerKilometer = 1.6;

        // Calculate total hours
        double totalHours = minutes / 60.0 + seconds / 3600.0;

        // Calculate average speed in miles per hour
        double averageSpeed = kilometers / totalHours * milesPerKilometer;

        // Display the result
        System.out.println("Average speed: " + averageSpeed + " miles per hour");
    }
}
