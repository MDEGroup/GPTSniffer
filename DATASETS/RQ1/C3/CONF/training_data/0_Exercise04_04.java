import java.util.Scanner;

public class HexagonArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the side of a hexagon
        System.out.print("Enter the side of a hexagon: ");
        double side = scanner.nextDouble();

        // Compute the area of the hexagon
        double area = (3 * Math.sqrt(3) / 2) * Math.pow(side, 2);

        // Display the area of the hexagon
        System.out.printf("The area of the hexagon with side %.2f is %.2f\n", side, area);

        scanner.close();
    }
}