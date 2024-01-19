

import java.util.*;


public class nan {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        int[][] brackets = {
                {8350, 33950, 82250, 171550, 372950}, 
                {16700, 67900, 137050, 20885, 372950}, 
                {8350, 33950, 68525, 104425, 186475}, 
                {11950, 45500, 117450, 190200, 372950} 
        };

        System.out.print("\n(0-single filer, 1-married jointly or "
                + "qualifying widow(er), 2-married separately, 3-head of " + "household) Enter the filing status: ");
        int status = input.nextInt();
        if (status > 3) {
            System.out.println("Error, Invalid Filling Status");
            return;
        }

        
        System.out.print("\nEnter the taxable income: ");
        double income = input.nextDouble();


        System.out.printf("Tax is $%.2f", calcTax(income, brackets[status], rates));
        input.close();

    }

    
    static double calcTax(double income, int[] bracket, double[] rates) {
        double tax = 0;
        if (income <= bracket[0]) {
            tax = income * rates[0];
        } else if (income <= bracket[1]) {
            tax = bracket[0] * rates[0] + (income - bracket[0]) * rates[1];
        } else if (income <= bracket[2]) {
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (income - bracket[1]) * rates[2];
        } else if (income <= bracket[3]) {
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (bracket[2] - bracket[1]) * rates[2]
                    + (income - bracket[2]) * rates[3];
        } else if (income <= bracket[4]) {
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (bracket[2] - bracket[1]) * rates[2]
                    + (bracket[3] - bracket[2]) * rates[3] + (income - bracket[4]) * rates[4];
        } else
            tax = bracket[0] * rates[0] + (bracket[1] - bracket[0]) * rates[1] + (bracket[2] - bracket[1]) * rates[2]
                    + (bracket[3] - bracket[2]) * rates[3] + (bracket[4] - bracket[3]) * rates[4] + (income - bracket[4]) * rates[5];

        return tax;

    }
}




