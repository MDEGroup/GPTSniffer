import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    // Default constructor
    public Account() {
        this(0, 0);
    }

    // Parameterized constructor
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    // Accessor method for account ID
    public int getId() {
        return id;
    }

    // Mutator method for account ID
    public void setId(int id) {
        this.id = id;
    }

    // Accessor method for account balance
    public double getBalance() {
        return balance;
    }

    // Mutator method for account balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Accessor method for annual interest rate
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Mutator method for annual interest rate
    public void setAnnualInterestRate(double rate) {
        this.annualInterestRate = rate;
    }

    // Accessor method for account creation date
    public Date getDateCreated() {
        return dateCreated;
    }

    // Calculate and return the monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // Calculate and return the monthly interest
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    // Method to withdraw a specified amount from the account
    public void withdraw(double amount) {
        balance -= amount;
    }

    // Method to deposit a specified amount into the account
    public void deposit(double amount) {
        balance += amount;
    }

    public static void main(String[] args) {
        // Create an account with initial values
        Account account = new Account(1122, 20000);
        
        // Set the annual interest rate
        account.setAnnualInterestRate(4.5);

        // Withdraw and deposit money
        account.withdraw(2500);
        account.deposit(3000);

        // Display account information
        System.out.println("Account ID: " + account.getId());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
        System.out.println("Account Created On: " + account.getDateCreated());
    }
}