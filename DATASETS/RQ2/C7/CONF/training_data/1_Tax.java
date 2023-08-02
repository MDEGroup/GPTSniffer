







public class Tax {
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private int[][] brackets;
    private double taxableIncome;
    private double[] rates;

    public Tax() {

    }

    Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        int[] bracket = brackets[filingStatus];

        if (taxableIncome <= bracket[0]) {
            return taxableIncome * rates[0];
        }
        int i = 1;
        double tax = bracket[0] * rates[0];
        while (i < bracket.length) {
            if (taxableIncome <= bracket[i]) {
                return tax + (taxableIncome - bracket[i - 1]) * rates[i];
            }
            tax += (bracket[i] - bracket[i - 1]) * rates[i];
            i++;
        }
        return tax + (taxableIncome - bracket[bracket.length - 1]) * rates[rates.length - 1];
    }


    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    private int getNumRates() {
        return rates.length;
    }

    @Override
    public String toString() {
        int[] bracket = brackets[filingStatus];
        return "Tax{" +
                "filingStatus=" + filingStatus +
                ", brackets=" + Arrays.toString(bracket) +
                ", taxableIncome=" + taxableIncome +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}
