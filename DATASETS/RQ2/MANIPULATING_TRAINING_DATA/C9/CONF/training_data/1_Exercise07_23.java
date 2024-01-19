package ch_07;

import java.util.Arrays;


public class Exercise07_23 {
    public static void main(String[] args) {
        boolean[] lockers = new boolean[100]; // true = open; false = closed;
        for (int student = 1; student <= 100; student++) {
            for (int action = student - 1; action < lockers.length; action += student) {
                lockers[action] = !lockers[action];
            }

        }
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i])
                System.out.print("Locker " + (i+1) + " is open \n");// Locker[0] represents Locker 1 hence the (i+1)
        }

    }
}
