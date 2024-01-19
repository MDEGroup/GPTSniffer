public class ApproximateEValueCalculator {
    public static void main(String[] args) {
        System.out.println("Approximating the value of e...");

        double eValue = 1; // Initializing e to 1
        double item = 1; // Initializing item to 1

        for (int i = 1; i <= 100000; i++) {
            item /= i; // Dividing item by i
            eValue += item; // Adding the new item to eValue
        }

        System.out.println("The approximate value of e for i = 100000 is: " + eValue);
    }
}