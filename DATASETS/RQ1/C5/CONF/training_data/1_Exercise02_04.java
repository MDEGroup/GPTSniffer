

import java.util.Scanner;


public class Pounds2Kilograms{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a value for number of pounds now: ");

        double numLbs = input.nextDouble();
        double numKilos = numLbs * 0.454;

        System.out.println(numLbs + " pounds is equal to " + numKilos + " kilograms");

    }

}
