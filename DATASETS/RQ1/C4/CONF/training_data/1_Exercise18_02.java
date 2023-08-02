

import java.util.Scanner;


public class Exercise18_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an index in the Fibonacci sequence: ");
        int idx = in.nextInt();

        System.out.println("Fibonacci num at " + idx + " is " + fib(idx));
        in.close();
    }

    static long fib(int idx) {
        long f0 = 0;
        long f1 = 1;
        long result = 0;
        for (int i = 1; i < idx; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }


}
