


public class Exercise10_08 {
    static final String COLUMN_HEADER = "Taxable Income |  Single Filer | Married jointly |  Married Separately |" +
            "  Head " +
            "Of House";

    public static void main(String[] args) {

        double[] rates2001 = {0.15, 0.275, 0.305, 0.355, 0.391};
        int[][] brackets2001 = {
                {27_050, 65_550, 136_750, 297_350}, 
                {45_200, 109_250, 166_500, 297_350}, 
                {22_600, 54_620, 83_250, 148_675}, 
                {36_250, 93_650, 151_650, 297_350} 
        };


        double[] rates2009 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        int[][] brackets2009 = {
                {8_350, 33_950, 82_250, 171_550, 372_950}, 
                {16_700, 67_900, 137_050, 20_885, 372_950}, 
                {8_350, 33_950, 68_525, 104_425, 186_475}, 
                {11_950, 45_500, 117_450, 190_200, 372_950} 
        };
        System.out.println("__________________________________ Tax Tables for 2001 __________________________________");
        printH2();
        for (int taxableIncome = 50_000; taxableIncome <= 60_000; taxableIncome += 1000) {

            System.out.printf("\t%d", taxableIncome);

            Tax taxHelper = new Tax(Tax.SINGLE_FILER, brackets2001, rates2001, taxableIncome);
            System.out.printf("\t\t\t %.2f", taxHelper.getTax());

            taxHelper.setFilingStatus(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER);
            System.out.printf("\t\t %.2f", taxHelper.getTax());

            taxHelper.setFilingStatus(Tax.MARRIED_SEPARATELY);
            System.out.printf("\t\t\t %.2f", taxHelper.getTax());

            taxHelper.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
            System.out.printf("\t\t\t %.2f" + "\n", taxHelper.getTax());


        }
        System.out.println("__________________________________ Tax Tables for 2009 __________________________________");
        printH2();
        for (int taxableIncome = 50_000; taxableIncome <= 60_000; taxableIncome += 1000) {

            System.out.printf("\t%d", taxableIncome);

            Tax taxHelper2 = new Tax(Tax.SINGLE_FILER, brackets2009, rates2009, taxableIncome);
            System.out.printf("\t\t\t %.2f", taxHelper2.getTax());

            taxHelper2.setFilingStatus(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER);
            System.out.printf("\t\t %.2f", taxHelper2.getTax());

            taxHelper2.setFilingStatus(Tax.MARRIED_SEPARATELY);
            System.out.printf("\t\t\t %.2f", taxHelper2.getTax());

            taxHelper2.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
            System.out.printf("\t\t\t %.2f" + "\n", taxHelper2.getTax());


        }
    }

    static void printH2() {
        System.out.println(COLUMN_HEADER);

    }
}