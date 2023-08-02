

import java.util.Scanner;


public class Exercise02_15 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x1 and y1: ");
        double x1, x2, y1, y2;

        x1 = input.nextDouble();
        y1 = input.nextDouble();

        System.out.println("Enter x2 and y2: ");

        x2 = input.nextDouble();
        y2 = input.nextDouble();

        double exs = Math.pow((x2 - x1), 2);
        double whys = Math.pow((y2 - y1), 2);

        double a = Math.pow((exs + whys), 0.5);

        System.out.println("The distance between the two points is " + a);


    }

}
