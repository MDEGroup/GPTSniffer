



public class CheckingAccount extends Account {

    public double minBalance;

    public CheckingAccount() {

        this.minBalance = -50;

    }

    public CheckingAccount(int id, double newBalance) {

        super(id, newBalance);
        this.minBalance = -50;
    }

    @Override
    public void withdraw(double amount) {

        if (this.getBalance() - amount < minBalance) {
            System.out.println("We cannot complete this transaction. \nIt will put you over your withdrawl limit.");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }

    @Override
    public String toString() {

        return super.toString() + "\nOverdraft protection up to : $" + minBalance;

    }
}
