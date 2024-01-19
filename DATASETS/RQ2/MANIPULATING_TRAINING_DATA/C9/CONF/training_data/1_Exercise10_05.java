package ch_10.exercise10_05;

import java.util.Scanner;


public class Exercise10_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(" Enter a positive integer to find its smallest factors: ");
        int n = in.nextInt();
        StackOfIntegers soi = new StackOfIntegers();
        StackOfIntegers revStack = new StackOfIntegers();
        for (int f = 2; n != 1; f++) {
            if (n % f == 0) {
                soi.push(f);
                n /= f;
                f = 1; // Reset the test factor
            }
        }

        while (!soi.empty()) {
            revStack.push(soi.pop());
        }
        while (revStack.getSize() > 1) {
            System.out.print(revStack.pop() + ", ");
        }
        System.out.print(revStack.pop()); //Print last number w/o a comma

        in.close();

    }

}
