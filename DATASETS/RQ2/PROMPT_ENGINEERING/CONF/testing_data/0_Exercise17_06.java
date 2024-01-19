import java.io.*;
import java.util.ArrayList;

// Define the Loan class implementing Serializable
class Loan implements Serializable {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    // Getters and setters for the fields (omitted for brevity)

    public double getMonthlyPayment() {
        // Calculate and return the monthly payment
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        // Calculate and return the total payment
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }
}

public class Exercise17_06 {
    public static void main(String[] args) {
        // Create an ArrayList to store Loan objects
        ArrayList<Loan> loans = new ArrayList<>();

        // Create five Loan objects and add them to the ArrayList
        loans.add(new Loan(5.0, 3, 1500));
        loans.add(new Loan(4.5, 2, 2000));
        loans.add(new Loan(6.2, 4, 2500));
        loans.add(new Loan(3.8, 5, 1800));
        loans.add(new Loan(4.0, 3, 2200));

        // Write the ArrayList of Loan objects to the file
        writeLoansToFile(loans, "Exercise17_06.dat");

        System.out.println("Loan objects have been written to Exercise17_06.dat.");
    }

    // Method to write Loan objects to a file
    public static void writeLoansToFile(ArrayList<Loan> loans, String file) {
        try {
            // Create an ObjectOutputStream to write objects to the file
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));

            // Write the ArrayList of Loan objects to the file
            output.writeObject(loans);

            // Close the ObjectOutputStream
            output.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}