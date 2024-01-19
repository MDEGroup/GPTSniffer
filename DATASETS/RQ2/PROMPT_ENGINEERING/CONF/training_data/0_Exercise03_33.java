import java.util.Scanner;

public class RiceComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt user to enter weight and price of first package
        System.out.print("Enter weight and price for package 1: ");
        double weight1 = input.nextDouble();
        double price1 = input.nextDouble();
        
        // Prompt user to enter weight and price of second package
        System.out.print("Enter weight and price for package 2: ");
        double weight2 = input.nextDouble();
        double price2 = input.nextDouble();
        
        // Calculate cost per unit of weight for each package
        double costPerUnitWeight1 = price1 / weight1;
        double costPerUnitWeight2 = price2 / weight2;
        
        // Compare the cost per unit weight of each package and display the better option
        if (costPerUnitWeight1 < costPerUnitWeight2) {
            System.out.println("Package 1 has a better price.");
        } else if (costPerUnitWeight2 < costPerUnitWeight1) {
            System.out.println("Package 2 has a better price.");
        } else {
            System.out.println("Both packages have the same price.");
        }
        
        input.close();
    }
}