
public class ShippingCost {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the weight of the package in pounds: ");
        double weight = input.nextDouble();

        
        double cost;
        if (weight > 50) {
            System.out.println("The package cannot be shipped.");
        } else if (weight > 10) {
            cost = 10.5;
            System.out.printf("The shipping cost is $%.2f\n", cost);
        } else if (weight > 3) {
            cost = 8.5;
            System.out.printf("The shipping cost is $%.2f\n", cost);
        } else if (weight > 1) {
            cost = 5.5;
            System.out.printf("The shipping cost is $%.2f\n", cost);
        } else if (weight > 0) {
            cost = 3.5;
            System.out.printf("The shipping cost is $%.2f\n", cost);
        } else {
            System.out.println("The weight must be greater than 0.");
        }
    }
}
