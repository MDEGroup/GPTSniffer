

import java.util.Scanner;


public class SolveLinearEquation {

    public static void main(String[] args) {
        double[][] a = new double[2][2];
        double[] b = new double[2];

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a00, a01, a10, a11, b0, and b1: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = in.nextDouble();
            }
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = in.nextDouble();
        }
        double[] res = linearEquation(a, b);
        System.out.println("Value of x is " + res[0]);
        System.out.println("Value of y is " + res[1]);
    }


    public static double[] linearEquation(double[][] a, double[] b) {
        double x = (b[0] * a[1][1]) - (b[1] * a[0][1]) / (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
        double y = (b[1] * a[0][0]) - (b[0] * a[1][0]) / (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
        return new double[]{x, y};
    }
}
