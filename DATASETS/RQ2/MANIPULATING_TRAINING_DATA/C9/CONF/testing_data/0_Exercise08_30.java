import java.util.Scanner;

public class LinearEquationSolver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Linear Equation Solver");
        System.out.println("Enter coefficients for the system of linear equations:");
        double[][] coefficients = new double[2][2];
        double[] constants = new double[2];

        // Input coefficients and constants
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter coefficient a" + i + j + ": ");
                coefficients[i][j] = input.nextDouble();
            }
        }

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter constant b" + i + ": ");
            constants[i] = input.nextDouble();
        }

        double[] solution = solveLinearEquation(coefficients, constants);

        if (solution == null) {
            System.out.println("The equation has no solution.");
        } else {
            System.out.println("Solution: x = " + solution[0] + ", y = " + solution[1]);
        }
    }

    public static double[] solveLinearEquation(double[][] coefficients, double[] constants) {
        double a00 = coefficients[0][0];
        double a01 = coefficients[0][1];
        double a10 = coefficients[1][0];
        double a11 = coefficients[1][1];

        double determinant = a00 * a11 - a01 * a10;

        if (determinant == 0) {
            return null; // No solution
        }

        double x = (constants[0] * a11 - constants[1] * a01) / determinant;
        double y = (constants[1] * a00 - constants[0] * a10) / determinant;

        return new double[]{x, y};
    }
}