




public class Account {

    private String ownerName;
    private ArrayList<Transaction> transactions;

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;


    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        transactions = new ArrayList<>();
    }

    public Account(String ownerName, int id, double balance) {
        this.ownerName = ownerName;
        this.id = id;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public Account(int newId, double newBalance) {
        this.id = newId;
        this.balance = newBalance;
        dateCreated = new Date();
        annualInterestRate = 0;
        transactions = new ArrayList<>();

    }

    public int getID() {

        return id;
    }

    public void setID(int newID) {

        this.id = newID;
    }

    public double getBalance() {

        return balance;
    }

    public void setBalance(double newBalance) {

        this.balance = newBalance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double newInterestRate) {

        this.annualInterestRate = newInterestRate;
    }

    public Date getDateCreated() {

        Date startDate = dateCreated;

        return startDate;
    }

    public double getMonthlyInterestRate() {

        return (annualInterestRate / 12);
    }

    public double getMonthlyInterest() {

        return balance * (this.getMonthlyInterestRate() / 100);
    }

    public void withdraw(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(Transaction.WITHDRAWAL, amount, this.balance, "Standard");
        transactions.add(transaction);

    }

    public void deposit(double amountDeposit) {
        balance += amountDeposit;
        Transaction transaction = new Transaction(Transaction.DEPOSIT, amountDeposit, this.balance, "Standard");
        transactions.add(transaction);

    }

    @Override
    public String toString() {
        return "Account Summary: \n" +
                "ownerName=" + ownerName +
                ", annualInterestRate=" + annualInterestRate + "%" +
                ", balance=$" + balance + "\n" +
                "Transactions:\n" + Arrays.toString(transactions.toArray());
    }

}
