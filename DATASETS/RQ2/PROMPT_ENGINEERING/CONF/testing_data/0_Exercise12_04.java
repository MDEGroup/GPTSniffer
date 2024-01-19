public class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /**
     * Constructs a loan with a specified annual interest rate,
     * number of years, and loan amount.
     *
     * @param annualInterestRate The annual interest rate for the loan.
     * @param numberOfYears      The number of years for the loan.
     * @param loanAmount         The loan amount.
     * @throws IllegalArgumentException if the loan amount, interest rate,
     *                                  or number of years is less than or equal to zero.
     */
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYears);
        setLoanAmount(loanAmount);
        this.loanDate = new java.util.Date();
    }

    /**
     * Returns the annual interest rate.
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Sets a new annual interest rate.
     *
     * @param annualInterestRate The new annual interest rate.
     * @throws IllegalArgumentException if the annual interest rate is less than or equal to zero.
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than zero.");
        }
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Returns the number of years.
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Sets a new number of years.
     *
     * @param numberOfYears The new number of years.
     * @throws IllegalArgumentException if the number of years is less than or equal to zero.
     */
    public void setNumberOfYears(int numberOfYears) {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Number of years must be greater than zero.");
        }
        this.numberOfYears = numberOfYears;
    }

    /**
     * Returns the loan amount.
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets a new loan amount.
     *
     * @param loanAmount The new loan amount.
     * @throws IllegalArgumentException if the loan amount is less than or equal to zero.
     */
    public void setLoanAmount(double loanAmount) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }
        this.loanAmount = loanAmount;
    }

    /**
     * Finds the monthly payment.
     */
    public double findMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfYears * 12));
    }

    /**
     * Finds the total payment.
     */
    public double findTotalPayment() {
        return findMonthlyPayment() * numberOfYears * 12;
    }

    /**
     * Returns the loan date.
     */
    public java.util.Date getLoanDate() {
        return loanDate;
    }
}