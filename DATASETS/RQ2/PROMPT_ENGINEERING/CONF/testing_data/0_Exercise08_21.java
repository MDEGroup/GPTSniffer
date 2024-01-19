import java.util.Scanner;

public class CentralCityFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of cities: ");
        int numberOfCities = input.nextInt();
        
        double[] xCoordinates = new double[numberOfCities];
        double[] yCoordinates = new double[numberOfCities];
        
        System.out.println("Enter the coordinates of the cities:");
        for (int i = 0; i < numberOfCities; i++) {
            System.out.print("City " + (i + 1) + " x-coordinate: ");
            xCoordinates[i] = input.nextDouble();
            
            System.out.print("City " + (i + 1) + " y-coordinate: ");
            yCoordinates[i] = input.nextDouble();
        }
        
        int centralCityIndex = 0;
        double minTotalDistance = Double.MAX_VALUE;
        
        for (int i = 0; i < numberOfCities; i++) {
            double totalDistance = 0;
            
            for (int j = 0; j < numberOfCities; j++) {
                if (i != j) {
                    double distance = Math.sqrt(Math.pow(xCoordinates[j] - xCoordinates[i], 2) +
                                                Math.pow(yCoordinates[j] - yCoordinates[i], 2));
                    totalDistance += distance;
                }
            }
            
            if (totalDistance < minTotalDistance) {
                minTotalDistance = totalDistance;
                centralCityIndex = i;
            }
        }
        
        System.out.println("The central city is at (" + xCoordinates[centralCityIndex] +
                            ", " + yCoordinates[centralCityIndex] + ")");
        System.out.println("The total distance to all other cities is " + minTotalDistance);
        
        input.close();
    }
}