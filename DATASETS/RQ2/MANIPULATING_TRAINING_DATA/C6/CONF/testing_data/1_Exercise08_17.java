

import java.util.*;


public class UnsafeBanks{
    static boolean test = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Exercise09_09 input (All input at once):");
        String lineOne = in.nextLine();
        String[] lOne = lineOne.split(" ");
        int n = Integer.parseInt(lOne[0]);
        int limit = Integer.parseInt(lOne[1]);

        double[][] banks = new double[n][];
        
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
            double assets = banks[i][0]; 

            for (int j = 0; j < borrowers[i].length; j++) {
                assets += borrowers[i][j];
            }
            if (assets < limit) {
                unsafeBanks[i] = 1;
                handleUnsafeBank(borrowers, i); 
                i = 0; 
            }
        }
        return unsafeBanks;
    }

    static void handleUnsafeBank(double[][] borrowers, int j) { 
        for (int i = 0; i < borrowers.length; i++) {
            
            
            borrowers[i][j] = 0.0;
        }

    }

    private static double[][] getBorrowers(double[][] banks) {
        double[][] borrowers = new double[banks.length][];
        for (int i = 0; i < banks.length; i++) {

            double numBorrowers = banks[i][1]; 
            int numBorrower = (int) (numBorrowers);
            double[] borrower = new double[banks.length];

            for (int x = 2; x < banks[i].length; x += 2) {
                double brwer = banks[i][x];
                int j = (int) (brwer);           
                borrower[j] = banks[i][x + 1];   

            }            
            borrowers[i] = borrower;
        }
        return borrowers;

    }
}

