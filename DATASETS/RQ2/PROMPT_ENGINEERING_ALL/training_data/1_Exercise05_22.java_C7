



public class LoanAmortizationSchedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the loan amount: ");
        double loanAmount = in.nextDouble();

        System.out.println("Number of years: ");
        int numYears = in.nextInt();

        System.out.println("Annual Interest Rate (as a percent (ex. enter '7' for 7%)): ");
        double rate = in.nextDouble();

        
        double monthlyInterestRate = rate / 1200;

        
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - 1 / Math.pow(1 + monthlyInterestRate, numYears * 12));
        System.out.printf("Monthly Payment: %.2f", monthlyPayment);

        double totalPayment = monthlyPayment * numYears * 12;

        System.out.printf("\nTotal Payment: %.2f", totalPayment);
        System.out.println();
        double balance = totalPayment;
        double principal;

        for (int i = 1; i <= numYears * 12; i++) {

            System.out.println("\nPayment# Interest Principal Balance");
            double interest = monthlyInterestRate * balance;
            principal = monthlyPayment - interest;
            balance = balance - principal;
            System.out.printf("%1d\t\t%4.2f\t\t%4.2f\t\t%.2f", i, interest, principal, balance);
        }


        in.close();
    }
}
