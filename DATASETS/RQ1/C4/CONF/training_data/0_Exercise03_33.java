import java.util.Scanner;

public class RiceComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Enter weight and price for package 1: ");
        double weight1 = input.nextDouble();
        double price1 = input.nextDouble();
        
        
        System.out.print("Enter weight and price for package 2: ");
        double weight2 = input.nextDouble();
        double price2 = input.nextDouble();
        
        
        double costPerUnitWeight1 = price1 / weight1;
        double costPerUnitWeight2 = price2 / weight2;
        
        
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