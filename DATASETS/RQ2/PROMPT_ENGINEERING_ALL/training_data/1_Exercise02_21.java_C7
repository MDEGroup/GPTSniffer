



public class FutureInvestmentValue {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = in.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double monthInterestRate = in.nextDouble();

        System.out.print("Enter number of years: ");
        double years = in.nextInt();



        years *= 12;
        monthInterestRate /= 1200; 

        System.out.printf("Accumulated Value is $%.2f",
                investmentAmount * Math.pow(monthInterestRate + 1, years));
        in.close();

    }

}
