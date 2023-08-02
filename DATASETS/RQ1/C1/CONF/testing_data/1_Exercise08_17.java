package ch_08;

import java.util.*;


public class Exercise08_17 {
    static boolean test = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
/*       It first reads two integers n and limit, where n indicates the number of banks and
         limit is the minimum total assets for keeping a bank safe. */
        System.out.println("Exercise09_09 input (All input at once):");
        String lineOne = in.nextLine();
        String[] lOne = lineOne.split(" ");
        int n = Integer.parseInt(lOne[0]);
        int limit = Integer.parseInt(lOne[1]);

        double[][] banks = new double[n][];
        /* then reads n lines that describe the information for n banks with IDs from 0 to n-1. */
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] lineValues = line.split(" ");
            double[] bank = new double[lineValues.length];

            for (int j = 0; j < lineValues.length; j++) {
                if (!lineValues[j].isEmpty())
                    bank[j] = Double.parseDouble(lineValues[j]);
            }
            banks[i] = bank;
        }

        double[][] borrowers = getBorrowers(banks);
        if (test) {
            System.out.println("Check borrowers result. Vertical index = Lending bank id, Horizontal index Borrower " +
                    "banks id: ");
            for (int i = 0; i < borrowers.length; i++) {
                System.out.print("Bank id# " + i + " has the following loans: ");
                System.out.println(Arrays.toString(borrowers[i]));
            }
        }
        int[] unsafeBanks = evaluateSafety(banks, borrowers, limit);

        System.out.print("Unsafe banks: ");
        for (int i = 0; i < unsafeBanks.length; i++) {
            if (unsafeBanks[i] == 1)
                System.out.print(i + " ");
        }


    }

    static int[] evaluateSafety(double[][] banks, double[][] borrowers, double limit) {
        int[] unsafeBanks = new int[borrowers.length];

        for (int i = 0; i < borrowers.length; i++) {
            if (unsafeBanks[i] == 1) continue;
            ;
            double assets = banks[i][0]; // Bank i's current balance

            for (int j = 0; j < borrowers[i].length; j++) {
                assets += borrowers[i][j];
            }
            if (assets < limit) {
                unsafeBanks[i] = 1;
                handleUnsafeBank(borrowers, i); //Remove loans to unsafe bank
                i = 0; //Re-check all banks with new unsafe bank values removed
            }
        }
        return unsafeBanks;
    }

    static void handleUnsafeBank(double[][] borrowers, int j) { //j = bank Id
        for (int i = 0; i < borrowers.length; i++) {
            // Sets all loans owed by bank id -> j to 0.0
            // The lender cannot count the loan in its total assets, for banks which are unsafe
            borrowers[i][j] = 0.0;
        }
//        return borrowers;
    }

    private static double[][] getBorrowers(double[][] banks) {
        double[][] borrowers = new double[banks.length][];
        for (int i = 0; i < banks.length; i++) {

            double numBorrowers = banks[i][1]; // second number indicates the # of banks that borrowed from the bank
            int numBorrower = (int) (numBorrowers);
            double[] borrower = new double[banks.length];

            for (int x = 2; x < banks[i].length; x += 2) {
                double brwer = banks[i][x];
                int j = (int) (brwer);           // The id of the borrower is j == index in borrower array
                borrower[j] = banks[i][x + 1];   // index x is 2 or 4 or 6 than the value is index 3,5,7

            }            /* the rest are pairs of numbers. Each pair describes a borrower.
            The first number in the pair is the borrower’s ID and the second is the amount borrowed */
            borrowers[i] = borrower;
        }
        return borrowers;

    }
}

