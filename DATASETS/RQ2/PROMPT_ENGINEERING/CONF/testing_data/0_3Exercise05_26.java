// Program to approximate the value of e using a series
public class ApproximateE {

    public static void main(String[] args) {
        // Display the header
        System.out.println("i\t\t\te");
        System.out.println("-----------------------------");

        // Initialize variables
        double e = 1.0; // The value of e
        double item = 1.0; // The current item in the series

        // Loop through values of i from 10000 to 100000 in increments of 10000
        for (int i = 10000; i <= 100000; i += 10000) {
            // Update the value of e using the series formula
            for (int j = 1; j <= i; j++) {
                item /= j;
            }
            e += item;

            // Display the result for the current i
            System.out.println(i + "\t\t\t" + e);
        }
    }
}