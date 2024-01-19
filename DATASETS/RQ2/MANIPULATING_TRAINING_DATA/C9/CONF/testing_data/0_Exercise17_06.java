import java.io.*;

// Define a class to represent a loan
class Loan implements Serializable {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    // Getter methods for Loan class can be added here

    @Override
    public String toString() {
        return "Loan [annualInterestRate=" + annualInterestRate + ", numberOfYears=" + numberOfYears + ", loanAmount="
                + loanAmount + "]";
    }
}

public class LoanSerializationDemo {
    public static void main(String[] args) {
        // Create five Loan objects
        Loan loan1 = new Loan(1.5, 10, 5000);
        Loan loan2 = new Loan(2.0, 15, 10000);
        Loan loan3 = new Loan(2.5, 20, 15000);
        Loan loan4 = new Loan(3.0, 25, 20000);
        Loan loan5 = new Loan(3.5, 30, 25000);

        // Serialize and write the Loan objects to a file
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_06.dat"))) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            output.writeObject(loan3);
            output.writeObject(loan4);
            output.writeObject(loan5);
            System.out.println("Loan objects have been serialized and written to the file.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Deserialize and read the Loan objects from the file
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_06.dat"))) {
            System.out.println("Reading Loan objects from the file:");
            while (true) {
                try {
                    Loan loan = (Loan) input.readObject();
                    System.out.println(loan);
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
