

import static java.lang.System.*;

import java.util.Scanner;


public class AverageAcceleration{
    public static void main(String[] args) {

        double v0, v1, t;

        Scanner input = new Scanner(System.in);
        out.println("Enter v0, v1, and t: ");

        v0 = input.nextDouble();
        v1 = input.nextDouble();
        t = input.nextDouble();

        double a = (v1 - v0) / t;

        out.printf("The average acceleration is %2.4f", a);
    }
}
