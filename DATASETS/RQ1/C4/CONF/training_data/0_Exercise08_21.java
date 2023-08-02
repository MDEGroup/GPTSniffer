import java.util.Scanner;

public class CentralCity {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the number of cities: ");
        int numCities = input.nextInt();

        
        int[] xCoords = new int[numCities];
        int[] yCoords = new int[numCities];

        
        for (int i = 0; i < numCities; i++) {
            System.out.print("Enter the x-coordinate of city " + (i + 1) + ": ");
            xCoords[i] = input.nextInt();
            System.out.print("Enter the y-coordinate of city " + (i + 1) + ": ");
            yCoords[i] = input.nextInt();
        }

        
        int centralCityIndex = 0;
        int shortestDistanceSum = Integer.MAX_VALUE;

        for (int i = 0; i < numCities; i++) {
            int distanceSum = 0;

            for (int j = 0; j < numCities; j++) {
                if (i != j) {
                    
                    int distance = (int) Math.sqrt(Math.pow(xCoords[j] - xCoords[i], 2) + Math.pow(yCoords[j] - yCoords[i], 2));
                    distanceSum += distance;
                }
            }

            
            if (distanceSum < shortestDistanceSum) {
                shortestDistanceSum = distanceSum;
                centralCityIndex = i;
            }
        }

        
        System.out.println("The central city is city " + (centralCityIndex + 1) + ".");
        System.out.println("The total distance from the central city to all other cities is " + shortestDistanceSum + ".");
    }
}

    if total_distance < min_total_distance:
        min_total_distance = total_distance
        central_city = i

print("The central city is at (%.1f, %.1f)" % cities[central_city])
print("The total distance to all other cities is %.2f" % min_total_distance)