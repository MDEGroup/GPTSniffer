package ch_11;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;


public class Exercise11_12 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter 5 numbers: ");
        for (int i = 0; i < 5; i++) {
            list.add(in.nextDouble());
        }
        System.out.println("Sum = " + sum(list));

        in.close();
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        ListIterator<Double> iterator = list.listIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

}
