import java.util.Scanner;

public class UnsafeBanksFinder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of banks and the limit: ");
        int n = input.nextInt();
        double limit = input.nextDouble();

        double[] balances = new double[n];
        double[][] borrowers = new double[n][n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter balance and number of loans for bank " + i + ": ");
            balances[i] = input.nextDouble();

            int numLoans = input.nextInt();
            for (int j = 0; j < numLoans; j++) {
                int borrowerId = input.nextInt();
                double amount = input.nextDouble();
                borrowers[i][borrowerId] = amount;
            }
        }

        boolean[] unsafe = new boolean[n];

        for (int i = 0; i < n; i++) {
            double totalAssets = balances[i];
            for (int j = 0; j < n; j++) {
                totalAssets += borrowers[j][i]; // Calculate total assets by adding loans from other banks
            }

            if (totalAssets < limit) {
                unsafe[i] = true; // Mark the bank as unsafe
            }
        }

        System.out.print("Unsafe banks are: ");
        for (int i = 0; i < n; i++) {
            if (unsafe[i]) {
                System.out.print(i + " ");
            }
        }

        input.close();
    }
}