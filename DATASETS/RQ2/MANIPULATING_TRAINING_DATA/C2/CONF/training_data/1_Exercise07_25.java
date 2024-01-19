

import java.util.Scanner;


public class Exercise07_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter values for a, b, and c: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        double[] values = new double[]{a, b, c};
        double[] rootVals = new double[2];

        int numRoots = solveQuadratic(values, rootVals);
        System.out.println("The number of real roots is " + numRoots);
        if (numRoots != 0) {
            System.out.print("The real roots values are: ");
            for (double value : rootVals) {
                if (value != 0.0) {
                    System.out.print(value + " ");
                }
            }
        }
        in.close();
    }

    public static int solveQuadratic(double[] eqn, double[] roots) {

        double dis = Math.pow(eqn[1], 2) - 4 * eqn[0] * eqn[2];

        if (dis < 0) {
            return 0;
        } else if (dis == 0) {
            roots[0] = (-1 * eqn[1]) + (Math.pow(dis, 0.5) / (2 * eqn[0]));
            return 1;

        } else {
            roots[0] = (-1 * eqn[1]) + (Math.pow(dis, 0.5) / (2 * eqn[0]));
            roots[1] = (-1 * eqn[1]) - (Math.pow(dis, 0.5) / (2 * eqn[0]));
            return 2;
        }

    }
}
