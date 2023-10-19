import java.util.Scanner;

public class BankSafetyChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the number of banks and the minimum total assets limit
        int numberOfBanks = input.nextInt();
        int totalAssetsLimit = input.nextInt();

        // Initialize arrays to store bank information
        int[] bankBalances = new int[numberOfBanks];
        int[][] loansToBanks = new int[numberOfBanks][numberOfBanks];

        // Read and store bank information
        for (int i = 0; i < numberOfBanks; i++) {
            bankBalances[i] = input.nextInt();
            int numLoans = input.nextInt();
            for (int j = 0; j < numLoans; j++) {
                int borrowerID = input.nextInt();
                int loanAmount = (int) input.nextDouble();
                loansToBanks[i][borrowerID] = loanAmount;
            }
        }

        // Identify unsafe banks
        boolean[] unsafeBanks = new boolean[numberOfBanks];

        for (int i = 0; i < numberOfBanks; i++) {
            int totalAssets = bankBalances[i];
            for (int j = 0; j < numberOfBanks; j++) {
                totalAssets += loansToBanks[i][j];
                if (totalAssets < totalAssetsLimit) {
                    unsafeBanks[i] = true;
                    break;
                }
            }
        }

        // Output the unsafe banks
        boolean foundUnsafeBank = false;
        System.out.print("Unsafe banks are: ");
        for (int i = 0; i < numberOfBanks; i++) {
            if (unsafeBanks[i]) {
                System.out.print(i + " ");
                foundUnsafeBank = true;
            }
        }
        if (!foundUnsafeBank) {
            System.out.println("None");
        }
    }
}