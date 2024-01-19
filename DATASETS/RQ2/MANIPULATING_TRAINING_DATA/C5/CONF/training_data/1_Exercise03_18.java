

import java.util.*;


public class ShippingCost {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your packages weight: ");
        String shipping = "";

        double weight = in.nextDouble();

        if (weight > 50) {
            System.out.println("The package cannot be shipped.");
            in.close();
            return;
        } else if (weight > 0 && weight <= 1) {
            shipping += 3.5;

        } else if (weight > 1 && weight <= 3) {
            shipping += 5.5;

        } else if (weight > 3 && weight <= 10) {
            shipping += 8.5;

        } else if (weight > 10 && weight <= 20) {
            shipping += 10.5;

        }
        System.out.println("With a package weight of " + weight + " your cost of shipping will be " + shipping);
        in.close();
    }
}
