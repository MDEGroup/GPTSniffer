import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the values for a, b, c, d, e, and f:");

        System.out.print("Enter a: ");
        double a = input.nextDouble();

        System.out.print("Enter b: ");
        double b = input.nextDouble();

        System.out.print("Enter c: ");
        double c = input.nextDouble();

        System.out.print("Enter d: ");
        double d = input.nextDouble();

        System.out.print("Enter e: ");
        double e = input.nextDouble();

        System.out.print("Enter f: ");
        double f = input.nextDouble();

        double determinant = a * d - b * c;

        if (determinant == 0) {
            System.out.println("The equation has no solution.");
        } else {
            double x = (e * d - b * f) / determinant;
            double y = (a * f - e * c) / determinant;

            System.out.println("x is " + x + " and y is " + y);
        }

        input.close();
    }
}