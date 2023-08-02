public class TaxTable {
    public static void main(String[] args) {
        System.out.println("Taxable Income    Single    Married Joint    Married    Head of");
        System.out.println("                  " + "        " + "or Qualifying    Separate    a House");
        System.out.println("                  " + "        " + "Widow(er)                   ");
        System.out.println("--------------------------------------------------------------");
        
        int status = 0;
        double taxableIncome;
        for (taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 50) {
            System.out.printf("%-18.0f", taxableIncome);
            System.out.printf("%-10.0f", computeTax(status, taxableIncome));
            System.out.printf("%-16.0f", computeTax(status + 1, taxableIncome));
            System.out.printf("%-12.0f", computeTax(status + 2, taxableIncome));
            System.out.printf("%-10.0f\n", computeTax(status + 3, taxableIncome));
        }
    }
    
    public static double computeTax(int status, double taxableIncome) {
        double tax = 0;
        
        if (status == 0) {
            if (taxableIncome <= 8350) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 33950) {
                tax = 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
            } else if (taxableIncome <= 82250) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (taxableIncome - 33950) * 0.25;
            } else if (taxableIncome <= 171550) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (taxableIncome - 82250) * 0.28;
            } else if (taxableIncome <= 372950) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                        + (taxableIncome - 171550) * 0.33;
            } else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15
                        + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28
                        + (372950 - 171550) * 0.33 + (taxableIncome - 372950) * 0.35;
            }
        } else if (status == 1) {
            
            
        } else if (status == 2) {
            
            
        } else if (status == 3) {
            
            
        }
        
        return Math.round(tax);
    }
}