import java.util.Scanner;

public class InvestmentValue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("The amount invested: ");
        double investmentAmount = input.nextDouble();
        
        System.out.print("Annual interest rate: ");
        double annualInterestRate = input.nextDouble();
        
        // Calculate monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;
        
        System.out.println("Years  Future Value");
        
        // Calculate and display future value for years from 1 to 30
        for (int years = 1; years <= 30; years++) {
            double futureValue = futureInvestmentValue(investmentAmount, monthlyInterestRate, years);
            System.out.printf("%-5d  $%9.2f\n", years, futureValue);
        }
    }
    
    /**
     * Computes future investment value at a given interest rate for a specified number of years.
     * @param investmentAmount the amount of money invested
     * @param monthlyInterestRate the interest rate per month
     * @param years the number of years
     * @return the future investment value
     */
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }

}
