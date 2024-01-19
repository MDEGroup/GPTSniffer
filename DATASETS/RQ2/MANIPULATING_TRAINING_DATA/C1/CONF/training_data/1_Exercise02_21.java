package ch_02;

import java.util.Scanner;


public class Exercise02_21 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = in.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double monthInterestRate = in.nextDouble();

        System.out.print("Enter number of years: ");
        double years = in.nextInt();

//		futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate)^(numberOfYears*12)

        years *= 12;
        monthInterestRate /= 1200; //Convert from yearly to monthly and from percent to decimal

        System.out.printf("Accumulated Value is $%.2f",
                investmentAmount * Math.pow(monthInterestRate + 1, years));
        in.close();

    }

}
