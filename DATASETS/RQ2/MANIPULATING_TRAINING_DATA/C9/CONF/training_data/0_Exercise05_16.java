import java.util.Scanner;

public class SmallestFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Find and display the smallest factors
        System.out.print("The smallest factors of " + number + " are: ");
        int factor = 2;
        while (factor <= number) {
            if (number % factor == 0) {
                System.out.print(factor + " ");
                number /= factor;
            } else {
                factor++;
            }
        }
    }
}
