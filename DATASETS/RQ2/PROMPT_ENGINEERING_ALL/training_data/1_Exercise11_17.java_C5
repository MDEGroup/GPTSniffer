

import java.util.ArrayList;
import java.util.Scanner;


public class MaxSquareNumberGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int m = in.nextInt();

        int n = findN(findSmallestFactors(m));
        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + m * n);

    }

    static ArrayList<Integer> findSmallestFactors(int m) {

        ArrayList<Integer> smallFactors = new ArrayList<>();

        for (int f = 2; m != 1; f++) {
            if (m % f == 0) {
                smallFactors.add(f);
                m /= f;
                f = 1; 
            }
        }
        return smallFactors;
    }

    static Integer findN(ArrayList<Integer> factors) {
        ArrayList<Integer> oddCounts = new ArrayList<>();
        for (int i = 0; i < factors.size(); i++) {
            int num = factors.get(i);
            int count = 0;
            for (Integer integer : factors) {
                if (integer == num) {
                    count++;
                }
            }
            if (count % 2 != 0 && !oddCounts.contains(num)) {
                oddCounts.add(num);
            }

        }

        Integer result = 1;
        for (Integer oddCount : oddCounts) {
            result *= oddCount;
        }
        return result;
    }

}
