

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class DateComparator{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        System.out.print("Enter 5 integers for list1: ");
        for (int i = 0; i < 5; i++) {
            one.add(in.nextInt());
        }
        System.out.print("Enter 5 integers for list2: ");
        for (int i = 0; i < 5; i++) {
            two.add(in.nextInt());
        }


        System.out.println("The combined list is " + union(one, two).toString());
        in.close();
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        list1.addAll(list2);
        return list1;

    }
}
