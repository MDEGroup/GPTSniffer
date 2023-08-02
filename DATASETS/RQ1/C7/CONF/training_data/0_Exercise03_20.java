
public class WindChill {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = scanner.nextDouble();

        if (temperature < -58 || temperature > 41) {
            System.out.println("Invalid temperature. Please enter a temperature between -58°F and 41°F.");
        } else if (windSpeed < 2) {
            System.out.println("Invalid wind speed. Please enter a wind speed of 2 miles per hour or greater.");
        } else {
            double windChill = 35.74 + 0.6215 * temperature - 35.75 * Math.pow(windSpeed, 0.16) + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
            System.out.printf("The wind-chill temperature is %.2f°F.\n", windChill);
        }
    }
}
