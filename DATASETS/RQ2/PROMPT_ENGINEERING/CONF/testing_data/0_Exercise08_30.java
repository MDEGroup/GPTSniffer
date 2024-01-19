import java.util.Scanner;

public class LinearEquationSolver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter coefficients for the 2x2 linear equation:");
        double[][] coefficients = new double[2][2];
        double[] constants = new double[2];

        System.out.print("a00: ");
        coefficients[0][0] = input.nextDouble();
        System.out.print("a01: ");
        coefficients[0][1] = input.nextDouble();
        System.out.print("a10: ");
        coefficients[1][0] = input.nextDouble();
        System.out.print("a11: ");
        coefficients[1][1] = input.nextDouble();

        System.out.println("Enter constants for the equation:");
        System.out.print("b0: ");
        constants[0] = input.nextDouble();
        System.out.print("b1: ");
        constants[1] = input.nextDouble();

        double[] solution = linearEquation(coefficients, constants);

        if (solution != null) {
            System.out.println("Solution: x = " + solution[0] + ", y = " + solution[1]);
        } else {
            System.out.println("The equation has no solution.");
        }
    }

    public static double[] linearEquation(double[][] coefficients, double[] constants) {
        double a00 = coefficients[0][0];
        double a01 = coefficients[0][1];
        double a10 = coefficients[1][0];
        double a11 = coefficients[1][1];
        double b0 = constants[0];
        double b1 = constants[1];

        double determinant = a00 * a11 - a01 * a10;

        if (determinant == 0) {
            return null; // No solution
        }

        double x = (b0 * a11 - b1 * a01) / determinant;
        double y = (b1 * a00 - b0 * a10) / determinant;

        return new double[]{x, y};
    }
}